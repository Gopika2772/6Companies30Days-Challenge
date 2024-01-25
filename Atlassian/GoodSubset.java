package Atlassian;

public class GoodSubset {
    final long mod=1000000007; 
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] numCount=new int[31];
        for(int num:nums)numCount[num]++;
        long ansWithOutZero=backTrack(numCount,new boolean[31],0)-1;
        
        return (int)(((ansWithOutZero+mod)*(power(2,numCount[1]))%mod));
    }
                     
     final int[][] primesAndMixes = new int[][] {
            {2},{3},{5},{7},{11},{13},{17},{19},{23},{29},
            {2,3},{2,5},{2,7},{2,11},{2,13},{3,5},{3,7},{2,3,5}
    };
    public long backTrack(int[] numCount,boolean[] used,int start){
        long ans=1;
        outer:
        for(int i=start;i<primesAndMixes.length;i++){
            int[] mix=primesAndMixes[i];
            int num=1;
            for(int prime:mix)if(used[prime])continue outer;
            for(int prime:mix){
                used[prime]=true;
                num*=prime;
            }
            if(numCount[num]!=0)ans=(ans+numCount[num]*backTrack(numCount,used,i+1)%mod);
            for(int prime:mix) used[prime]=false;            

        }
        return ans;        
    }                 
    public int power(int x,int pow){
        if(pow==0)return 1;
          return (int) ((power(x, pow - 1) * (long) x) % mod);
    }
    
}