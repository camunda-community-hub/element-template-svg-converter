package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

public class RectHandler {

    public static SVGDocument transformRect(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {

        Node parentNode = node.getParentNode();

        // Get the root element (the 'svg' element).
        Element svgRoot = svg.getDocumentElement();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

        Element rect = svg.createElementNS(svgNS, "rect");
        NamedNodeMap nnm = node.getAttributes();
        if (nnm.getNamedItem("x") != null) {
            System.out.println("Found rect x " + nnm.getNamedItem("x").getTextContent());
            Float x = Float.valueOf(nnm.getNamedItem("x").getTextContent());
            Float newX = Float.valueOf(targetWidth) / Float.valueOf(originalWidth) * x;
            rect.setAttribute("x", newX.toString());
        }

        if (nnm.getNamedItem("y") != null) {
            System.out.println("Found rect y " + nnm.getNamedItem("y").getTextContent());
            Float y = Float.valueOf(nnm.getNamedItem("y").getTextContent());
            Float newY = Float.valueOf(targetHeight) / Float.valueOf(originalHeight) * y;
            rect.setAttribute("y", newY.toString());
        }

        if (nnm.getNamedItem("width") != null) {
            System.out.println("Found rect width " + nnm.getNamedItem("width").getTextContent());
            Float width = Float.valueOf(nnm.getNamedItem("width").getTextContent());
            Float newWidth = Float.valueOf(targetWidth) / Float.valueOf(originalWidth) * width;
            rect.setAttribute("width", newWidth.toString());
        }

        if (nnm.getNamedItem("height") != null) {
            System.out.println("Found rect height " + nnm.getNamedItem("height").getTextContent());
            Float height = Float.valueOf(nnm.getNamedItem("height").getTextContent());
            Float newHeight = Float.valueOf(targetHeight) / Float.valueOf(originalHeight) * height;
            rect.setAttribute("height", newHeight.toString());
        }

        if (nnm.getNamedItem("class") != null) {
            rect.setAttribute("class", nnm.getNamedItem("class").getTextContent());
        }
        if (nnm.getNamedItem("id") != null) {
            rect.setAttribute("id", nnm.getNamedItem("id").getTextContent() ) ;
        }
        if (nnm.getNamedItem("style") != null) {
            rect.setAttribute("style", nnm.getNamedItem("style").getTextContent() ) ;
        }
        if (nnm.getNamedItem("class") != null) {
            rect.setAttribute("class", nnm.getNamedItem("class").getTextContent() ) ;
        }

        parentNode.replaceChild(rect, node);

        return svg;
    }
}
