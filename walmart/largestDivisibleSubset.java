import java.util.*;

class largestDivisibleSubset {
    public List<Integer> largestDivisiblesubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        return construct(nums, dp, maxIndex, maxSize);
    }

    private List<Integer> construct(int[] nums, int[] dp, int maxIndex, int maxSize) {
        List<Integer> result = new ArrayList<>();
        int currentSize = maxSize;
        int currentPrev = nums[maxIndex];

        for (int i = maxIndex; i >= 0; i--) {
            if (currentSize > 0 && dp[i] == currentSize && currentPrev % nums[i] == 0) {
                result.add(nums[i]);
                currentPrev = nums[i];
                currentSize--;
            }
        }

        return result;
    }
}
