package org.svg.utilities;

import org.apache.batik.parser.ParseException;
import org.apache.batik.parser.PointsHandler;

import java.io.StringWriter;

public class CustomPointsHandler implements PointsHandler {

    private StringWriter points;
    private float origWidth;
    private float origHeight;
    private float newWidth;
    private float newHeight;
    private float factorX;
    private float factorY;

    public CustomPointsHandler(float ow, float oh, float nw, float nh) {
        points = new StringWriter();
        origWidth = ow;
        origHeight = oh;
        newWidth = nw;
        newHeight = nh;
        factorX = nw/ow;
        factorY = nh/oh;
    }

    public String getPoints() {
        return points.toString();
    }

    @Override
    public void startPoints() throws ParseException {

    }

    @Override
    public void point(float v, float v1) throws ParseException {
        points.append(v*factorX +","+ v1*factorY+" ");
    }

    @Override
    public void endPoints() throws ParseException {

    }
}
