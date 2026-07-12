class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        if(n==0) return new int[0];

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i]; 
            dp[i][1] = i;     
        }

        Arrays.sort(dp, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[n];
        int rank = 1;

        res[dp[0][1]] = rank;

        for (int i = 1; i < n; i++) {
            if (dp[i][0] != dp[i - 1][0]) {
                rank++;
            }
            res[dp[i][1]] = rank;
        }

        return res;
    }
}