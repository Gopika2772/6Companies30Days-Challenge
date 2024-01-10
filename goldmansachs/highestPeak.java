import java.util.*;
class highestPeak {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][] ans=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.add(new Pair(i,j));
                }
            }
        }
        List<Integer> temp=new ArrayList<>(Arrays.asList(-1,0,1,0,-1));
        while(!(q.size()==0)){
            Pair curPair=q.poll();
            int x=curPair.x;
            int y=curPair.y;
            int val=ans[x][y];
            
            for(int i=0;i<temp.size()-1;i++){
                int newX = x + temp.get(i);
                int newY = y + temp.get(i + 1);

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && ans[newX][newY] == -1) {
                    ans[newX][newY] = val + 1;
                    q.add(new Pair(newX, newY));
                }
            }
        }
        return ans;
    }
}
