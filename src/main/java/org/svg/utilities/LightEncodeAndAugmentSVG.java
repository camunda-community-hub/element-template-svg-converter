package org.svg.utilities;

import java.io.*;

public class LightEncodeAndAugmentSVG {

    public static void main(String[] args) {
        if(args[0].equals(null)) {
            System.out.println("Need to provide the SVG file as an arg to this utility");
            return;
        }

        File file = new File(args[0]);
        StringBuilder rawFile = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                rawFile.append(line);
            }
        } catch (Exception e) {
            System.out.println("exception while reading file - "+e);
        }

        StringBuilder result = new StringBuilder();
        result.append("\"data:image/svg+xml,");

        result.append(rawFile.toString().replace("<", "%3C")
                .replace(">", "%3E")
                .replace("\"", "'")
                .replace("#", "%23")
                .replace("{", "%7B")
                .replace("}", "%7D")
                .replace("\n", "")
                .replace("\r", "")
                .replace("\t", " "));

        result.append("\"");

        System.out.println("Copy this into your Element Template file \"icon\": \"contents\" section - "+ result);
    }
}
