package Atlassian;
import java.util.*;
class squareHole {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        int maxH=calcBar(hBars);
        int maxV=calcBar(vBars);
        int res=Math.min(maxH,maxV)+1;
        return res*res;

    }
    public int calcBar(int[] Bar){
        if (Bar.length == 1) {
            return 1;
        }
        Arrays.sort(Bar);
        int max=1;int i=0;int n=Bar.length;
        while(i<n){
            int maxStreak=1;
            
            while(i+1<n && Bar[i]+1 == Bar[i+1]){
                i++;
                maxStreak++;
            }
            i++;
            max = Math.max(max, maxStreak);
        }    
        return max;
    }
}
