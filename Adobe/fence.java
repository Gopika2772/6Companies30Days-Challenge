package Adobe;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class fence {

    class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] outerTrees(int[][] trees) {
        List<Point> pointList=new ArrayList<>();
        List<Point> ans=new ArrayList<>();
 
        for(int[] p:trees){
            pointList.add(new Point(p[0],p[1]));
        }
        int n=pointList.size();
        if(n==1)return trees;
        Collections.sort(pointList,(a,b)->a.y==b.y?a.x-b.x:a.y-b.y);
        
        Stack<Point> hull=new Stack<>();
        
        hull.push(pointList.get(0));
        hull.push(pointList.get(1));

        //lower hull
        for(int i=2;i<n;i++){
            Point top=hull.pop();
            while(!hull.isEmpty() && ccw(hull.peek(),top,pointList.get(i))>0){
                top=hull.pop();
            }
            hull.push(top);
            hull.push(pointList.get(i));
        } 
        //Upper hull
        for(int i=n-2;i>=0;i--){
            Point top=hull.pop();
            while(!hull.isEmpty() && ccw(hull.peek(),top,pointList.get(i))>0){
                top=hull.pop();
            }
            hull.push(top);
            hull.push(pointList.get(i));
        } 
        
        Set<ArrayList<Integer>> dup=new HashSet<>();
        
        for(Point p:hull){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(p.x);temp.add(p.y);
            if(dup.contains(temp))continue;
            dup.add(temp);
            ans.add(p);
        }
        
        int[][] res=new int[ans.size()][2];
        int i=0;
        for(Point p:ans){
            res[i][0]=p.x;
            res[i][1]=p.y;
            i++;
        }
        return res;
    }
    
    public int ccw(Point a,Point b, Point c){
        double angle=(b.x-a.x)*(c.y-b.y)-(c.x-b.x)*(b.y-a.y);
        if(angle<0)return -1;
        else if(angle>0)return 1;
        else return 0;
    }
}
