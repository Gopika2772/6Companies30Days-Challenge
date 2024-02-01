package Google;
import java.util.*;


class doll {
    public int maxEnvelopes(int[][] envelopes) {
              Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        
        return len;
    
    }
}
