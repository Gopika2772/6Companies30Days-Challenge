
class maxRotate {
    public int maxrotate(int[] nums) {

        long total=0,sum=0;
        long maxSum=Integer.MIN_VALUE;
        int n=nums.length;
       
        for(int i=0;i<n;i++){
            total+=nums[i];
            sum+=(nums[i]*i);
        }
        maxSum=Math.max(maxSum,sum);

        
        for(int i=n-1;i>0;i--){
            sum=sum+total-(nums[i]*(n));
            maxSum=Math.max(maxSum,sum);
        }

        return (int)maxSum;
    }
}