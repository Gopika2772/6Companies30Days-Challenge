package Adobe;

import java.util.ArrayDeque;
import java.util.Deque;

public class subsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();
        int[] sum = new int[n];
        int max = nums[0];
        sum[0] = nums[0];

        for(int i=0;i<n;i++) {
            if(deque.isEmpty()) {
                deque.addLast(i);
            } else {
            //window size
                while(!deque.isEmpty() && deque.getFirst() < (i-k)) {
                    deque.pollFirst();
                }

                sum[i] = Math.max(sum[deque.getFirst()] + nums[i], nums[i]);
                max = Math.max(max, sum[i]);

                while(!deque.isEmpty() && sum[deque.getLast()] <= sum[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
        }

        return max;
    }
    
}
