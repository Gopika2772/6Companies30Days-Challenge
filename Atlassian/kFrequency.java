package Atlassian;
import java.util.*;


class kFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int maxi=0;int i=0;
        int j=0;
          for(i=0;i<nums.length;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                while(j<nums.length && map.get(nums[i])>k){
                    maxi=Math.max(maxi,i-j);
                   map.put(nums[j],map.get(nums[j])-1);
                    j++;
                }

        }
        maxi=Math.max(maxi,i-j);
        return maxi;
       
        
    }
}