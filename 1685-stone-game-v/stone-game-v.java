class Solution {
    int dp[][];
    public int stoneGameV(int[] nums) {
        int n = nums.length;

        dp= new int[n][n];

        for(int i=0; i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return solve(0, n - 1, nums);
    }

    public int solve(int start, int end, int[] nums) {
        if (start == end) {
            return 0;
        }

        int ans = 0;

        if(dp[start][end]!=-1) return dp[start][end];

        for (int idx = start; idx < end; idx++) {

            int leftSum = nums[idx] - (start > 0 ? nums[start - 1] : 0);

            int rightSum = nums[end] - nums[idx];

            if (leftSum < rightSum) {

                ans = Math.max(ans, leftSum + solve(start, idx, nums));

            } else if (leftSum > rightSum) {

                ans = Math.max(ans, rightSum + solve(idx + 1, end, nums));

            } else {
                ans = Math.max(ans, leftSum + Math.max(solve(start, idx, nums), solve(idx + 1, end, nums)));
            }
        }

        return dp[start][end]=ans;
    }
}