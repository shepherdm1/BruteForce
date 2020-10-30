import java.awt.Point;
import java.lang.Math;
import java.util.ArrayList;

public class ClosetPair {

    /**
     * @param args the command line arguments
     */
    
    public static Integer closestPoint(ArrayList<Point> p){
        ArrayList<Point> arrL = new ArrayList<Point>();

        Integer d = null ;
        int formula = (int) ();


        for(int i=1;i < p.size(); i++ ){
            for(int j=i+1;j < p.size();j++ ){
                d = (Math.min(d, Math.sqrt(Math.pow((p.get(i).x-x2),2))+ (Math.pow((y1-y2),2))));
                
            }
        }


        return d;
    }
    
}
