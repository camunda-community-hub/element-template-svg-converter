package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGDocument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupHandler {

    public static SVGDocument transformGroup(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {

        Node parentNode = node.getParentNode();
        NodeList newGroupNodeList = new NodeList() {
            @Override
            public Node item(int index) {
                return null;
            }

            @Override
            public int getLength() {
                return 0;
            }
        };

        NodeList groupNodeList = node.getChildNodes();
        for (int x=0; x < groupNodeList.getLength(); x++) {
            NamedNodeMap nnm = node.getAttributes();
            String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

            Element group = svg.createElementNS(svgNS, "g");

            String nodeName = groupNodeList.item(x).getNodeName();
            switch (nodeName) {
                case "path":
                    svg = CustomPathHandler.handlePath(svg, groupNodeList.item(x), originalWidth, originalHeight, targetWidth, targetHeight);
                    break;

                case "circle":
                    svg = CircleHandler.transformCircle(svg, groupNodeList.item(x), originalWidth, originalHeight, targetWidth, targetHeight);
                    break;

                case "style":
                    svg = StyleHandler.transformStyle(svg, groupNodeList.item(x), originalWidth, originalHeight, targetWidth, targetHeight);
                    break;

                case "polygon":
                    svg = PolygonHandler.transformPolygon(svg, groupNodeList.item(x), originalWidth, originalHeight, targetWidth, targetHeight);
                    break;

                case "rect":
                    svg = RectHandler.transformRect(svg, groupNodeList.item(x), originalWidth, originalHeight, targetWidth, targetHeight);
                    break;

                case "#text":
                    // Ignore these
                    break;

                default:
                    System.out.println("New SVG item encountered. Need a handler for " + nodeName);
            }

            if (nnm.getNamedItem("id") != null) {
                group.setAttribute("id", nnm.getNamedItem("id").getTextContent());
            }
            if (nnm.getNamedItem("style") != null) {
                group.setAttribute("style", nnm.getNamedItem("style").getTextContent());
            }
            if (nnm.getNamedItem("fill") != null) {
                group.setAttribute("fill", nnm.getNamedItem("fill").getTextContent());
            }

            if (nnm.getNamedItem("id") != null) {
                group.setAttribute("id", nnm.getNamedItem("id").getTextContent());
            }

            if (nnm.getNamedItem("class") != null) {
                group.setAttribute("class", nnm.getNamedItem("class").getTextContent());
            }

            if (nnm.getNamedItem("transform") != null) {
                String translate = nnm.getNamedItem("transform").getTextContent();
                Pattern pattern = Pattern.compile("(translate\\()(.*)(,)(.*)(\\)(^rotate\\())", Pattern.DOTALL);
                Matcher matcher = pattern.matcher(translate);
                boolean matchFound = matcher.find();
                if (matchFound) {
                    System.out.println("Match found");
                    System.out.println(matcher.group(2) + " " + matcher.group(4));
                    String newX = String.valueOf((Float.valueOf(targetWidth) / Float.valueOf(originalWidth)) * Float.valueOf(matcher.group(2)));
                    String newY = String.valueOf((Float.valueOf(targetHeight) / Float.valueOf(originalHeight)) * Float.valueOf(matcher.group(4)));
                    group.setAttribute("transform", "translate(" + newX + "," + newY + ")");
                } else {
                    System.out.println("Match not found, trying another");
                    Pattern pattern1 = Pattern.compile("(translate\\()(.*)(,)(.*)(\\))(\\srotate\\()(.*)(\\))", Pattern.DOTALL);
                    Matcher matcher1 = pattern1.matcher(translate);
                    boolean matchFound1 = matcher1.find();
                    if (matchFound1) {
                        System.out.println("Match found with rotate");
                        String newX = String.valueOf((Float.valueOf(targetWidth) / Float.valueOf(originalWidth)) * Float.valueOf(matcher1.group(2)));
                        String newY = String.valueOf((Float.valueOf(targetHeight) / Float.valueOf(originalHeight)) * Float.valueOf(matcher1.group(4)));
                        group.setAttribute("transform", "translate(" + newX + "," + newY + ")" + " rotate(" + (matcher1.group(7).length() > 0 ? matcher1.group(7) : "") + ")");
                    } else {
                        System.out.println("Secondary match not found");
                    }
                }
            }

            /*NodeList newChildren = node.getChildNodes();
            for (int i=0; i < newChildren.getLength(); i++) {
                group.appendChild(newChildren.item(i));
            }
            System.out.println(parentNode.getNodeName()+" "+group.getNodeName());*/
            //parentNode.replaceChild(group, node);
        }
        return svg;
    }
}
