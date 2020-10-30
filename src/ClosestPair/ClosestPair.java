package ClosestPair;

import java.awt.*;
import java.util.ArrayList;
public class ClosestPair {
    public static double closestPoint(ArrayList<Point> p){
        double d = Double.POSITIVE_INFINITY ;
        for(int i=0;i < p.size(); i++ ){
            for(int j=i+1;j < p.size();j++ ){
                d = (Math.min(d, Math.sqrt(Math.pow((p.get(i).x-p.get(j).x),2)) + (Math.pow((p.get(i).y-p.get(j).y),2))));
            }
        }
        return d;
    }
    public static void main(String[] args) {
        ArrayList<Point> p = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int randx = (int) (Math.random() * 10) + 1;
            int randy = (int) (Math.random() * 10) + 1;
            Point pnt = new Point(randx, randy);
            p.add(pnt);
            System.out.println(pnt.toString().replace("java.awt.Point", "").replace("[", "(").replace("]", ")").replace("x=", "").replace("y=", ""));
        }

        System.out.println(ClosestPair.closestPoint(p));
    }
}