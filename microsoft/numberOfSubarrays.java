class numberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmostk(nums, k) - atmostk(nums, k - 1);
    }

    private int atmostk(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0) {
                count += 1;
            }
            while (start <= end && count > k) {
                if (nums[start++] % 2 != 0) {
                    count--;
                }
            }
            ans += (end - start + 1);
        }
        return ans;
    }
}
