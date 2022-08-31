package org.svg.utilities;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.parser.ParseException;
import org.apache.batik.parser.PathHandler;
import org.apache.batik.parser.PathParser;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPathHandler implements PathHandler {

    private StringWriter path;
    private float origWidth;
    private float origHeight;
    private float newWidth;
    private float newHeight;
    private float factorX;
    private float factorY;

    public CustomPathHandler(float ow, float oh, float nw, float nh) {
        path = new StringWriter();
        origWidth = ow;
        origHeight = oh;
        newWidth = nw;
        newHeight = nh;
        factorX = ow/nw;
        factorY = oh/nh;
    }

    public static SVGDocument handlePath(SVGDocument svg, Node node, String originalWidth, String originalHeight, String targetWidth, String targetHeight) {
        Node parentNode = node.getParentNode();
        NamedNodeMap nnm = node.getAttributes();
        Node dNode = nnm.getNamedItem("d");

        PathParser pp = new PathParser();
        CustomPathHandler mph = new CustomPathHandler(Float.valueOf(originalWidth), Float.valueOf(originalHeight) , Float.valueOf(targetWidth), Float.valueOf(targetHeight));
        pp.setPathHandler(mph);
        pp.parse(dNode.getTextContent());

        Element path = svg.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "path");
        path.setAttributeNS(null, "d",mph.getPath());

        System.out.println("d is "+mph.getPath());

        if (nnm.getNamedItem("id") != null) {
            path.setAttribute("id", nnm.getNamedItem("id").getTextContent() ) ;
        }
        if (nnm.getNamedItem("style") != null) {
            path.setAttribute("style", nnm.getNamedItem("style").getTextContent());
        }
        if (nnm.getNamedItem("fill") != null) {
            path.setAttribute("fill", nnm.getNamedItem("fill").getTextContent());
        }

        if (nnm.getNamedItem("id") != null) {
            path.setAttribute("id", nnm.getNamedItem("id").getTextContent());
        }

        if (nnm.getNamedItem("class") != null) {
            path.setAttribute("class", nnm.getNamedItem("class").getTextContent());
        }

        if (nnm.getNamedItem("transform") != null) {
            String translate = nnm.getNamedItem("transform").getTextContent();
            Pattern pattern = Pattern.compile("(translate\\()(.*)(,)(.*)(\\)(.*))", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(translate);
            boolean matchFound = matcher.find();
            if(matchFound) {
                System.out.println("Match found");
                System.out.println(matcher.group(2) + " " + matcher.group(4));
                String newX = String.valueOf((Float.valueOf(targetWidth) / Float.valueOf(originalWidth)) * Float.valueOf(matcher.group(2)));
                String newY = String.valueOf((Float.valueOf(targetHeight) / Float.valueOf(originalHeight)) * Float.valueOf(matcher.group(4)));
                path.setAttribute("transform", "translate(" + newX + "," + newY + ")"+ (matcher.group(6).length() > 0 ? " "+matcher.group(6) : "")) ;
            } else {
                System.out.println("Match not found");
            }
        }

        parentNode.replaceChild(path, node);

        return svg;
    }

    public String getPath() {
        return path.toString();
    }

    @Override
    public void startPath() throws ParseException {
        //System.out.println("start");
    }

    @Override
    public void endPath() throws ParseException { // z command
        //System.out.println("z end");
        path.append("z");
    }

    @Override
    public void movetoRel(float v, float v1) throws ParseException { // m command
        //System.out.println("m move to Rel v is "+v);
        //System.out.println("m move to Rel v1 is "+v1);
        path.append("m "+v/factorX +" "+ v1/factorY+" ");
    }

    @Override
    public void movetoAbs(float v, float v1) throws ParseException { // M command
        //System.out.println("M move to Abs v is "+v);
        //System.out.println("M move to Abs v1 is "+v1);
        path.append("M "+v/factorX +" "+ v1/factorY+" ");

    }

    @Override
    public void closePath() throws ParseException {
        //System.out.println("close path");
    }

    @Override
    public void linetoRel(float v, float v1) throws ParseException { // l command
        //System.out.println("l line to Rel v is "+v);
        //System.out.println("l line to Rel v1 is "+v1);
        path.append("l "+v/factorX+" "+v1/factorY+" ");
    }

    @Override
    public void linetoAbs(float v, float v1) throws ParseException { // L command
        //System.out.println("L line to Abs v is "+v);
        //System.out.println("L line to Abs v1 is "+v1);
        path.append("L "+v/factorX+" "+v1/factorY+" ");
    }

    @Override
    public void linetoHorizontalRel(float v) throws ParseException { // h command
        //System.out.println("h line to Horiz Rel v is "+v);
        path.append("h "+v/factorX+" ");
    }

    @Override
    public void linetoHorizontalAbs(float v) throws ParseException { // H command
        //System.out.println("H line to Horiz Abs v is "+v);
        path.append("H "+v/factorX+" ");
    }

    @Override
    public void linetoVerticalRel(float v) throws ParseException { // v command
        //System.out.println("v line to Vert Rel v is "+v);
        path.append("v "+v/factorY+" ");
    }

    @Override
    public void linetoVerticalAbs(float v) throws ParseException { // V command
        //System.out.println("V line to Vert Abs v is "+v);
        path.append("V "+v/factorY+" ");
    }

    @Override
    public void curvetoCubicRel(float v, float v1, float v2, float v3, float v4, float v5) throws ParseException { // c command
        /*System.out.println("c curve to Cubic Rel v is "+v);
        System.out.println("c curve to Cubic Rel v1 is "+v1);
        System.out.println("c curve to Cubic Rel v2 is "+v2);
        System.out.println("c curve to Cubic Rel v3 is "+v3);
        System.out.println("c curve to Cubic Rel v4 is "+v4);
        System.out.println("c curve to Cubic Rel v5 is "+v5); */
        path.append("c "+v/factorX+" "+v1/factorY+","+v2/factorX+" "+v3/factorY+","+v4/factorX+" "+v5/factorY+" ");
    }

    @Override
    public void curvetoCubicAbs(float v, float v1, float v2, float v3, float v4, float v5) throws ParseException { // C command
        /*System.out.println("C curve to Cubic Abs v is "+v);
        System.out.println("C curve to Cubic Abs v1 is "+v1);
        System.out.println("C curve to Cubic Abs v2 is "+v2);
        System.out.println("C curve to Cubic Abs v3 is "+v3);
        System.out.println("C curve to Cubic Abs v4 is "+v4);
        System.out.println("C curve to Cubic Abs v5 is "+v5);*/
        path.append("C "+v/factorX +" "+ v1/factorY+","+v2/factorX+" "+ v3/factorY+","+v4/factorX +" "+ v5/factorY+" ");
    }

    @Override
    public void curvetoCubicSmoothRel(float v, float v1, float v2, float v3) throws ParseException { // s command
        /*System.out.println("s curve to Cubic Smooth Rel v is "+v);
        System.out.println("s curve to Cubic Smooth Rel v1 is "+v1);
        System.out.println("s curve to Cubic Smooth Rel v2 is "+v2);
        System.out.println("s curve to Cubic Smooth Rel v3 is "+v3);*/
        path.append("s "+v/factorX +" "+ v1/factorY+","+v2/factorX+" "+ v3/factorY+" ");
    }

    @Override
    public void curvetoCubicSmoothAbs(float v, float v1, float v2, float v3) throws ParseException { // S command
        /*System.out.println("S curve to Cubic Smooth Abs v is "+v);
        System.out.println("S curve to Cubic Smooth Abs v1 is "+v1);
        System.out.println("S curve to Cubic Smooth Abs v2 is "+v2);
        System.out.println("S curve to Cubic Smooth Abs v3 is "+v3);*/
        path.append("S "+v/factorX +" "+ v1/factorY+","+v2/factorX+" "+ v3/factorY+" ");
    }

    @Override
    public void curvetoQuadraticRel(float v, float v1, float v2, float v3) throws ParseException { // q command
        /*System.out.println("q curve to Quad Rel v is "+v);
        System.out.println("q curve to Quad Rel v1 is "+v1);
        System.out.println("q curve to Quad Rel v2 is "+v2);
        System.out.println("q curve to Quad Rel v3 is "+v3);*/
    }

    @Override
    public void curvetoQuadraticAbs(float v, float v1, float v2, float v3) throws ParseException { // Q command
        /*System.out.println("Q curve to Quad Abs v is "+v);
        System.out.println("Q curve to Quad Abs v1 is "+v1);
        System.out.println("Q curve to Quad Abs v2 is "+v2);
        System.out.println("Q curve to Quad Abs v3 is "+v3);*/
    }

    @Override
    public void curvetoQuadraticSmoothRel(float v, float v1) throws ParseException { // t command
        //System.out.println("t curve to Quad Smooth Rel v is "+v);
        //System.out.println("t curve to Quad Smooth Rel v1 is "+v1);
    }

    @Override
    public void curvetoQuadraticSmoothAbs(float v, float v1) throws ParseException { // T command
        //System.out.println("T curve to Quad Smooth Abs v is "+v);
        //System.out.println("T curve to Quad Smooth Abs v1 is "+v1);
    }

    @Override
    public void arcRel(float v, float v1, float v2, boolean b, boolean b1, float v3, float v4) throws ParseException { // a command
        /*System.out.println("a arc Rel v is "+v);
        System.out.println("a arc Rel v1 is "+v1);
        System.out.println("a arc Rel v2 is "+v2);
        System.out.println("a arc Rel b is "+b);
        System.out.println("a arc Rel b1 is "+b1);
        System.out.println("a arc Rel v3 is "+v3);
        System.out.println("a arc Rel v4 is "+v4); */
        int bInt = b ? 1 : 0;
        int b1Int = b1 ? 1 : 0;
        path.append("a "+v/factorX +","+ v1/factorY+","+v2+","+bInt+","+b1Int+","+v3/factorY+","+v4/factorX +" ");
    }

    @Override
    public void arcAbs(float v, float v1, float v2, boolean b, boolean b1, float v3, float v4) throws ParseException { // A command
        /*System.out.println("A arc Abs v is "+v);
        System.out.println("A arc Abs v1 is "+v1);
        System.out.println("A arc Abs v2 is "+v2);
        System.out.println("A arc Abs b is "+b);
        System.out.println("A arc Abs b1 is "+b1);
        System.out.println("A arc Abs v3 is "+v3);
        System.out.println("A arc Abs v4 is "+v4);*/
        int bInt = b ? 1 : 0;
        int b1Int = b1 ? 1 : 0;
        path.append("A "+v/factorX +","+ v1/factorY+","+v2+","+bInt+","+b1Int+","+v3/factorY+","+v4/factorX +" ");
    }
}
