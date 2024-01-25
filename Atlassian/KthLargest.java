package Atlassian;
import java.util.*;
class KthLargest {
    private PriorityQueue<Integer> pq;
    private int t;

    public KthLargest(int k, int[] nums) {
        t = k;
        pq = new PriorityQueue<>();

        for (int x : nums) {
            pq.offer(x);

            if (pq.size() > k)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > t)
            pq.poll();

        return pq.peek();
    }
}
