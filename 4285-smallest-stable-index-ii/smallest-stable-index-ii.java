class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int arr[] = new int[nums.length];
        arr[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = Math.min(nums[i], arr[i + 1]);
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = arr[i];
            max = Math.max(nums[i], max);

            if (max - min <= k)
                return i;

        }

        return -1;
    }
}