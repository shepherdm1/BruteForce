package ConvexHull;

import java.awt.*;
import java.util.ArrayList;


public class ConvexHull {
    public static ArrayList<Point> hullCalc(ArrayList<Point> p){
        ArrayList<Point> l= new ArrayList<>();

        for(int i = 0; i<p.size() - 1; i++){
            for(int j = i+1;j<p.size();j++){
                Point p1 = p.get(i);
                Point p2 = p.get(j);
                int sign = 0;

                int x1 = (int) p1.getX();
                int y1 = (int) p1.getY();
                int x2 = (int) p2.getX();
                int y2 = (int) p2.getX();

                int a = y2-y1;
                int b = x1-x2;
                int c = (x1*y2)-(y1*x2);

                boolean foundProblem = false;

                int tmp = (int) Double.POSITIVE_INFINITY;

                for (int k = 0; k < p.size(); k++) {
                    Point p3 = p.get(k);
                    int region = a* (int) p3.getX() + b* (int) p3.getY() - c;

                    if (sign != 0) {
                        if (region > 0 && sign < 0) {
                            foundProblem = true;
                            break;
                        } else if (region < 0 && sign > 0) {
                            foundProblem = true;
                            break;
                        }
                    } else {
                        if (region > 0) {
                            sign = 1;
                        } else if (region < 0) {
                            sign = -1;
                        }
                    }

                }

                if (!foundProblem) {
                    if (!l.contains(p1)) {
                        l.add(p1);
                    }
                    if (!l.contains(p2)) {
                        l.add(p2);
                    }
                }

                /*for(int k=0;k<p.size();k++){
                    int x3 = (int) p.get(k).getX();
                    int y3 = (int) p.get(k).getY();
                    if(!(x3==x1&&y3==y1)&&!(x3==x2&&y3==y2)){
                        int check = a*p.get(k).x + b*p.get(k).y-c;
                        if(tmp==(int) Double.POSITIVE_INFINITY){
                            tmp = check;
                        }
                        else if ((tmp>=0&&check<0)||(tmp<0&&check>=0)){
                            foundProblem = true;
                            break;
                        }
                    }
                }
                if(!foundProblem){
                    l.add(new Point[]{p.get(i), p.get(j)});
                }*/
            }
        }
        return l;
    }
    public static void main(String[] args){
        ArrayList<Point> p= new ArrayList<>();
        for(int i = 0; i<10; i++){
            int randx = (int)(Math.random() * 10) + 1;
            int randy = (int)(Math.random() * 10) + 1;
            Point pnt = new Point(randx,randy);
            p.add(pnt);
            System.out.println(pnt.toString().replace("java.awt.Point", "").replace("[", "(").replace("]", ")").replace("x=", "").replace("y=", ""));
        }

        ArrayList<Point> solution = hullCalc(p);

        System.out.println("Output: ");
        for (Point point :  solution) {
            System.out.printf("(%.1f, %.1f)", point.getX(), point.getY());
        }

        /*for (int z = 0; z< ConvexHull.hullCalc(p).size(); z++){
            System.out.println(hullCalc(p).get(z)[0].toString().replace("java.awt.Point", "").replace("[", "(").replace("]", ")").replace("x=", "").replace("y=", "") + " - " + hullCalc(p).get(z)[1].toString().replace("java.awt.Point", "").replace("[", "(").replace("]", ")").replace("x=", "").replace("y=", ""));        }*/
    }
}