class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int x : set) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (int x : freq.keySet()) {
            if (freq.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}