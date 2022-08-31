package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.parser.PointsParser;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

public class PolygonHandler {

    public static SVGDocument transformPolygon(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {

        Node parentNode = node.getParentNode();

        // Get the root element (the 'svg' element).
        Element svgRoot = svg.getDocumentElement();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

        NamedNodeMap nnm = node.getAttributes();
        Node points = nnm.getNamedItem("points");

        PointsParser pp = new PointsParser();
        CustomPointsHandler cph = new CustomPointsHandler(Float.valueOf(originalWidth), Float.valueOf(originalHeight) , Float.valueOf(targetWidth), Float.valueOf(targetHeight));
        pp.setPointsHandler(cph);
        pp.parse(points.getTextContent());

        Element polygon = svg.createElementNS(svgNS, "polygon");
        polygon.setAttributeNS(null, "points",cph.getPoints());

        if (nnm.getNamedItem("class") != null) {
            polygon.setAttribute("class", nnm.getNamedItem("class").getTextContent());
        }
        if (nnm.getNamedItem("id") != null) {
            polygon.setAttribute("id", nnm.getNamedItem("id").getTextContent() ) ;
        }
        if (nnm.getNamedItem("style") != null) {
            polygon.setAttribute("style", nnm.getNamedItem("style").getTextContent() ) ;
        }
        if (nnm.getNamedItem("class") != null) {
            polygon.setAttribute("class", nnm.getNamedItem("class").getTextContent() ) ;
        }

        parentNode.replaceChild(polygon, node);

        return svg;
    }
}
