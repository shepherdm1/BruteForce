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

//syh
        return d;
    }
}
