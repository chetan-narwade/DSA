class Solution {
    public boolean uniformArray(int[] nums1) {
        int minimum = Integer.MAX_VALUE;
        boolean even = true;

        for (int num : nums1) {
            minimum = Math.min(minimum, num);

            if (num % 2 == 1) {
                even = false;
            }
        }

        return even || minimum % 2 == 1;
    }
}