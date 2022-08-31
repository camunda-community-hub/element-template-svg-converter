package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CircleHandler {

    public static SVGDocument transformCircle(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {

        Node parentNode = node.getParentNode();

        // Get the root element (the 'svg' element).
        Element svgRoot = svg.getDocumentElement();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;


        // Check to see if part of a group that already has been processed
        Element circle = svg.createElementNS(svgNS, "circle");
        NamedNodeMap nnm = node.getAttributes();
        if (nnm.getNamedItem("id") != null) {
            circle.setAttribute("id", nnm.getNamedItem("id").getTextContent() ) ;
        }

        if (nnm.getNamedItem("cx") != null) {
            Float x = Float.valueOf(nnm.getNamedItem("cx").getTextContent());
            Float newX = Float.valueOf(targetWidth)/Float.valueOf(originalWidth) * x;
            circle.setAttribute("cx", newX.toString());
        }

        if (nnm.getNamedItem("cy") != null) {
            Float y = Float.valueOf(nnm.getNamedItem("cy").getTextContent());
            Float newY = Float.valueOf(targetHeight)/Float.valueOf(originalHeight) * y;
            circle.setAttribute("cy", newY.toString());
        }

        if (nnm.getNamedItem("r") != null) {
            Float r = Float.valueOf(nnm.getNamedItem("r").getTextContent());
            Float newR = Float.valueOf(targetHeight)/Float.valueOf(originalHeight) * r;
            circle.setAttribute("r", newR.toString());
        }

        if (nnm.getNamedItem("fill") != null) {
            circle.setAttribute("id", nnm.getNamedItem("fill").getTextContent() ) ;
        }

        parentNode.replaceChild(circle, node);

        return svg;
    }
}
