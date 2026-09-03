class Solution {
    int odd = Integer.MAX_VALUE;

    public boolean uniformArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd = Math.min(odd, nums[i]);
            }
        }

        return solve(nums, false) || solve(nums, true);
    }

    public boolean solve(int nums[], boolean isOdd) {

        for (int i = 0; i < nums.length; i++) {
            if (isOdd) {
                if (nums[i] % 2 == 0 && odd >= nums[i]) {
                    return false;
                }
            } else {
                if (nums[i] % 2 == 1 && odd >= nums[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}