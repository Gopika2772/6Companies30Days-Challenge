import java.util.*;
class smallestTrimmedNumbers {
    private class Pair{
        String s;
        int index;
        Pair(String s,int index){
            this.s=s;
            this.index=index;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer,List<Pair>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            String str=nums[i];
            int n=str.length();
            int l=n;
            for(int j=0;j<n;j++){
                map.putIfAbsent(l,new ArrayList<>());
                Pair pair=new Pair(str.substring(j),i);
                map.get(l--).add(pair);
            }
        }
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] q:queries ){
            int k=q[0];
            int trim=q[1];
            
            List<Pair> list=map.get(trim);
            Collections.sort(list,(p1,p2)->{
                if(p1.s.equals(p2.s)){
                    return p1.index-p2.index;
                }
                return p1.s.compareTo(p2.s);
            });
            ans[i++]=list.get(k-1).index;
        }
        return ans;
    }
}
