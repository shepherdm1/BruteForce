package ConvexHull;

import java.awt.*;
import java.util.ArrayList;

public class ConvexHull {
    public static ArrayList<Point> convexHull(ArrayList<Point> points) {
        ArrayList<Point> output = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                boolean problem = false;
                int sign = 0;

                Point p1 = points.get(i);
                Point p2 = points.get(j);

                int x1 = (int) p1.getX();
                int x2 = (int) p2.getX();
                int y1 = (int) p1.getY();
                int y2 = (int) p2.getY();

                int a = y2 - y1;
                int b = x1 - x2;
                int c = (x1 * y2) - (y1 * x2);

                for (int k = 0; k < points.size(); k++) {
                    Point p3 = points.get(k);

                    int x3 = (int) p3.getX();
                    int y3 = (int) p3.getY();

                    int region = (a * x3) + (b * y3) - c;

                    if (sign != 0) {

                        if (region > 0 && sign < 0 ||  region < 0 && sign > 0) {
                            problem = true;
                            break;
                        }

                    } else {
                        if (region > 0) {
                            sign = 1;
                        } else sign = -1;
                    }
                }

                if (!problem) {
                    if (!output.contains(p1)) {
                        output.add(p1);
                    }
                    if (!output.contains(p2)) {
                        output.add(p2);
                    }
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        ArrayList<Point> p = new ArrayList<>();
        System.out.println("10 Randomly generated points:");
        for (int i = 0; i < 10; i++) {
            int randx = (int) (Math.random() * 10) + 1;
            int randy = (int) (Math.random() * 10) + 1;
            Point pnt = new Point(randx, randy);
            p.add(pnt);
            System.out.println(pnt.toString().replace("java.awt.Point", "").replace("[", "(").replace("]", ")").replace("x=", "").replace("y=", ""));
        }

        ArrayList<Point> solution = convexHull(p);

        System.out.println("\nPoints that make up convex hull given generated points:");
        for (Point point : solution) {
            System.out.printf("(%.1f, %.1f)", point.getX(), point.getY());
        }

    }
}
