import java.awt.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        ArrayList<Point> p= new ArrayList<>();
        for(int i = 0; i<10; i++){
            int randx = (int)(Math.random() * 10) + 1;
            int randy = (int)(Math.random() * 10) + 1;
            p.add(new Point(randx,randy));
        }

        ClosetPair.closestPoint(p);
        ConvexHull.hullCalc(p);
    }
}
