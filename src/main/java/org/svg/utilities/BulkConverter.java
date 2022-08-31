package org.svg.utilities;

import java.io.File;

public class BulkConverter {

    public static void main(String[] args) {

        // Check to see if directory has been passed as an arg
        if(args.length < 4) {
            System.out.println("Need to pass in directly where the SVGs are located, location of element template file, desired icon width in pixels, which task to apply it to");
            return;
        }

        System.out.println("args is "+ args[0]);
        File folder = new File(args[0]);
        File[] listOfFiles = folder.listFiles();

        StringBuilder sb = new StringBuilder("<tr>");
        int rowIndex = 0;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                String strippedFileName = listOfFiles[i].getName().replace(".svg", "");

                String[] forRescaler = {args[0]+listOfFiles[i].getName(), args[2], args[3], strippedFileName, strippedFileName, args[4], args[0], args[1]};

                RescaleImageBulkHelper.rescaleImage(forRescaler);

                // build row for GitHub repo table
                if(rowIndex < 10) {
                    //<tr><td><a href="./converted-svg-snippets/coffeeCup.txt"><img src="./svgs/coffee-cup.svg"></a></td><td><a href="./converted-svg-snippets/greyCoffeeCup.txt"><img src="./svgs/coffee-cup-grey.svg"></a></td><td><a href="./converted-svg-snippets/coffeeCircle.txt"><img src="./svgs/coffee-circle.svg"></a></td><td><a href="./converted-svg-snippets/yellowCoffeeCircle.txt"><img src="./svgs/coffee-circle-yellow.svg"></a></td></tr>
                    sb.append("<td width=\"100px\"><a href=\""+args[5]+listOfFiles[i].getName().replace(".svg", ".txt")+"\"><img src=\""+args[6]+listOfFiles[i].getName()+"\"></a></td>");
                    rowIndex ++;
                } else {
                    sb.append("</tr><tr>");
                    rowIndex = 0;
                }
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        if(rowIndex < 10){
            sb.append("</tr><tr>");
        }

        // print out table
        System.out.println("table is "+sb.toString());
    }
}
