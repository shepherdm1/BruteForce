package closetpair;
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
        int x1 = 2;
        int x2 = -2;
        int y1 = 2;
        int y2 = -3;
        int formula = (int) (Math.sqrt(Math.pow((x1-x2),2))+ (Math.pow((y1-y2),2)));
        for(int i=1;i < arrL.size(); i++ ){
            for(int j=i+1;i < arrL.size();j++ ){
                d = (Math.min(d, formula));
                
            }
        }


        return d;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
