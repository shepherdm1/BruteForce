import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ConvexHull {
    public static ArrayList<Point[]> hullCalc(ArrayList<Point> p){
        ArrayList<Point[]> l= new ArrayList<>();

        for(int i = 0; i<p.size(); i++){
            for(int j = i+1;i<p.size();i++){
                int a = p.get(j).y - p.get(i).y;
                int b = p.get(i).x - p.get(j).x;
                int c = (p.get(i).x*p.get(j).y)-(p.get(i).y*p.get(j).x);
                boolean foundProblem = false;
                int tmp = 0;
                for(int k=0;k<p.size();k++){
                    if(!(p.get(k).equals(p.get(i))||p.get(k).equals(p.get(j)))){
                        int check = a*p.get(k).x + b*p.get(k).y-c;
                        if(tmp==0){
                            tmp = check;
                        }
                        else if (tmp/Math.abs(tmp)!=check/Math.abs(check)){
                            foundProblem = true;
                            break;
                        }
                    }
                }
                if(!foundProblem){
                    l.add(new Point[]{p.get(i), p.get(j)});
                }
            }
        }
        return l;
    }
}
