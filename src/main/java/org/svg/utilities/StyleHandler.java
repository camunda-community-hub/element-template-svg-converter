package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StyleHandler {

    public static SVGDocument transformStyle(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {

        Node parentNode = node.getParentNode();

        // Get the root element (the 'svg' element).
        Element svgRoot = svg.getDocumentElement();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

        Element style = svg.createElementNS(svgNS, "style");
        NamedNodeMap nnm = node.getAttributes();

        if (nnm.getNamedItem("id") != null) {
            style.setAttribute("id", nnm.getNamedItem("id").getTextContent() ) ;
        }
        if (nnm.getNamedItem("type") != null) {
            style.setAttribute("type", nnm.getNamedItem("type").getTextContent());
            style.setTextContent(node.getTextContent());
        }
        // Need to check for content and CDATA

        String content = node.getTextContent();
        StringBuilder newContent = new StringBuilder();
        int index = 0;

        // look for translates to refactor
        Pattern pattern = Pattern.compile("(translate\\()([0-9|.|-]*)(px,)([0-9|.]*)(px\\))*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()) {
            String newX = String.valueOf(Float.valueOf(targetWidth)/Float.valueOf(originalWidth) * Float.valueOf(matcher.group(2)));
            String newY = String.valueOf(Float.valueOf(targetHeight)/Float.valueOf(originalHeight) * Float.valueOf(matcher.group(4)));
            newContent.append(content.substring(index, matcher.start())+"translate("+newX+"px,"+newY+"px)");
            index = matcher.end();
        }

        // need to add the rest, if any
        newContent.append(content.substring(index));

        if(content != null) {
            style.setTextContent(newContent.toString());
        }

        parentNode.replaceChild(style, node);
        return svg;
    }
}
