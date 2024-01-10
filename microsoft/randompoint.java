import java.util.*;
class randompoint {
    int[][] arr;
    int[][] ans;
    int index;
    Random rand;

    public void Solution(int[][] rects) {
        this.arr=rects;
        this.ans=new int[10001][2];
        this.index=0;
        this.rand=new Random();

        for(int i=0;i<arr.length;i++){
            int x1=arr[i][0];
            int y1=arr[i][1];
            int x2=arr[i][2];
            int y2=arr[i][3];
            for(int x=x1;x<=x2;x++){
                for(int y=y1;y<=y2;y++){
                    if(index==ans.length){
                        break;
                    }
                    ans[index][0]=x;
                    ans[index][1]=y;
                    index++;
                }
            }
        }
    }
    
    public int[] pick() {
        int randomIndex=rand.nextInt(index);
        return new int[]{ans[randomIndex][0],ans[randomIndex][1]};
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */