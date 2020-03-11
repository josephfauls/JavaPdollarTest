

import test1.*;

import test1.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;


public class Test {

    public static void main(String args[]) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("src/arrowhead.txt"));
        String line = reader.readLine();
        int strokeCount = 0;
        int i = 0;
        Vector v = new Vector();
        while(line != null) {
            line = reader.readLine();
            if (line == null) {break;}
            if (line == "END") {strokeCount++;}
            if (line.charAt(0)!='B' && line.charAt(0)!='E') {
                int comma = line.indexOf(',');
                float x,y;
                x = Float.parseFloat(line.substring(0,comma));
                y = Float.parseFloat(line.substring(comma+1));
                Point point1 = new Point(x,y,strokeCount);
                v.add(point1);
            }
        }
        int size = v.size();
        Point[] myPoints = new Point[size];
        for (int j = 0; j < size;j++) {
            myPoints[j] = (Point) v.get(j);
        }
        Gesture arrowhead;
        arrowhead = new Gesture(myPoints,"arrowhead");
        Gesture[] myGests = new Gesture[1];
        myGests[0] = arrowhead;
        PointCloudRecognizer pDollar = new PointCloudRecognizer();
        String what = pDollar.Classify(arrowhead,myGests);

    }
}
