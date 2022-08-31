package org.svg.utilities;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGDocument;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RescaleImageBulkHelper {

    public static void rescaleImage(String[] args) {

        try {
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);

            String uri = "file:///"+args[0];
            String elementTemplateLocation = args[1];
            String targetWidth = args[2];
            //String targetHeight = args[2];
            String templateId = args[3];
            String templateName = args[4];
            String appliesTo = args[5];
            boolean templateMatch = false;

            SVGDocument svg = f.createSVGDocument(uri);

            // Get the root element (the 'svg' element).
            Element svgRoot = svg.getDocumentElement();

            // get width and height of original svg viewbox
            NamedNodeMap nnmRoot = svg.getRootElement().getAttributes();
            String[] vbElements = nnmRoot.getNamedItem("viewBox").getNodeValue().split(" ");
            String originalWidth = vbElements[2];
            String originalHeight = vbElements[3];
            Float calcTargetHeight = (Float.valueOf(targetWidth)/Float.valueOf(originalWidth) * Float.valueOf(originalHeight));
            String targetHeight = calcTargetHeight.toString();

            // Set the width and height attributes on the root 'svg' element.
            svgRoot.setAttributeNS(null, "width", targetWidth);
            svgRoot.setAttributeNS(null, "height", targetHeight);
            svgRoot.setAttributeNS(null, "viewbox", "0 0 "+targetWidth+" "+targetHeight);

            // First we'll process anything inside groups to maintain SVG fidelity as best as possible. Then we'll process each possible standalone type
            NodeList nl = svg.getElementsByTagName("g");
            for (int i=0; i < nl.getLength(); i++) {
                System.out.println("handling groups");
                svg = GroupHandler.transformGroup(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
            }

            Node parentNode = null;

            // Now we look for other elements not in groups and transform them
            nl = svg.getElementsByTagName("style");
            for (int i=0; i < nl.getLength(); i++) {
                parentNode = nl.item(i).getParentNode();
                // if parent node is a group, ignore it since it was already processed
                if(!parentNode.getNodeName().equals("g")) {
                    svg = StyleHandler.transformStyle(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
                }
            }

            nl = svg.getElementsByTagName("circle");
            for (int i=0; i < nl.getLength(); i++) {
                parentNode = nl.item(i).getParentNode();
                // if parent node is a group, ignore it since it was already processed
                if (!parentNode.getNodeName().equals("g")) {
                    svg = CircleHandler.transformCircle(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
                }
            }

            nl = svg.getElementsByTagName("path");
            for (int i=0; i < nl.getLength(); i++) {
                parentNode = nl.item(i).getParentNode();
                // if parent node is a group, ignore it since it was already processed
                if(!parentNode.getNodeName().equals("g")) {
                    svg = CustomPathHandler.handlePath(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
                }
            }

            nl = svg.getElementsByTagName("polygon");
            for (int i=0; i < nl.getLength(); i++) {
                parentNode = nl.item(i).getParentNode();
                // if parent node is a group, ignore it since it was already processed
                if (!parentNode.getNodeName().equals("g")) {
                    svg = PolygonHandler.transformPolygon(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
                }
            }

            nl = svg.getElementsByTagName("rect");

            for (int i=0; i < nl.getLength(); i++) {
                parentNode = nl.item(i).getParentNode();
                // if parent node is a group, ignore it since it was already processed
                if (!parentNode.getNodeName().equals("g")) {
                    svg = RectHandler.transformRect(svg, nl.item(i), originalWidth, originalHeight, targetWidth, targetHeight);
                }
            }

            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(svg), new StreamResult(sw));
            System.out.println("svg is " + sw.toString());


            StringBuilder sb = new StringBuilder("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='"+targetWidth+"' height='"+targetHeight+"' viewBox='0 0 "+targetWidth+" "+targetHeight+"' %3E");

            String svgString = sw.toString();
            // Look for original svg start tag and remove it
            Pattern pattern = Pattern.compile("(.*)(<svg[^>]+>)(.*)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(svgString);
            boolean matchFound = matcher.find();
            if(matchFound) {
                svgString = matcher.group(1) + matcher.group(3);
            } else {
                System.out.println("Match not found");
            }

            // Look for comments in the svg and remove them as well
            pattern = Pattern.compile("(.*)(<!--[^>]+>)(.*)", Pattern.DOTALL);
            matcher = pattern.matcher(svgString);
            matchFound = matcher.find();
            if(matchFound) {
                svgString = matcher.group(1) + matcher.group(3);
            } else {
                System.out.println("Match not found");
            }

            svgString = svgString.replace("<", "%3C")
                     .replace(">", "%3E")
                     .replace("\"", "'")
                     .replace("#", "%23")
                     .replace("{", "%7B")
                     .replace("}", "%7D")
                     .replace("\n", "")
                     .replace("\r", "")
                     .replace("\t", " ");

            sb.append(svgString);

            File file = new File(elementTemplateLocation);
            String content = FileUtils.readFileToString(file, "utf-8");

            // Get array of element templates  and see if entries exist to overwrite
            JSONArray jsonArray = new JSONArray(content);
            ListIterator iter = jsonArray.toList().listIterator();
            while(iter.hasNext()){
                int index = iter.nextIndex();
                HashMap json = (HashMap) iter.next();
                String id = (String) json.get("id");
                //System.out.println("id is "+id);
                if (templateId.equals(id)) {
                    templateMatch = true;
                    System.out.println("Matching ID found");
                    //Overwrite existing entry
                    jsonArray.remove(index);

                    jsonArray = ElementTemplateHandler.addOrUpdateArray(jsonArray,index, templateName, templateId, appliesTo, sb, templateMatch);
                }

            }

            if (!templateMatch){
                //Add entry in element templates
                jsonArray = ElementTemplateHandler.addOrUpdateArray(jsonArray,0 , templateName, templateId, appliesTo, sb, templateMatch);
            }

            //Write to file
            try (PrintWriter out = new PrintWriter(new FileWriter(elementTemplateLocation))) {
                out.write(jsonArray.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("final sb is "+sb);
            // Now write it to a txt file for use as an SVG snippet
            System.out.println("txt file is"+args[7]+args[4]+".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[7]+args[4]+".txt"));
            writer.write(sb.toString());
            writer.close();

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            System.out.println("Uh oh "+sStackTrace);
        }
    }
}