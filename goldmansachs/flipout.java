import java.util.*;
class flipout {
    
    Map<Integer,Integer> map;
    int m, n, total;
    Random rand;

    public flipout(int m, int n) {
        map=new HashMap<>();
        rand=new Random();
        this.m=m;
        this.n=n;
        total=m*n;
    }
    
    public int[] flip() {
        int r=rand.nextInt(total--);
        int x=map.getOrDefault(r,r);
        map.put(r,map.getOrDefault(total,total));
        return new int[]{x/n,x%n};
    }
    
    public void reset() {
        map.clear();
        total=m*n;
    }
}

