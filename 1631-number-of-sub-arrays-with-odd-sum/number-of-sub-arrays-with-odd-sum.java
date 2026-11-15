class Solution {

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int n = arr.length;
        
        int[][] dp = new int[2][2];
        
        int count = dp[1][0];
        
        for (int i = 0; i < n; i++) {
            int idx = i & 1;
            int parity = arr[i] & 1;
            
            dp[parity][idx] = (1 + dp[0][1 - idx]) % MOD;
            dp[1 - parity][idx] = dp[1][1 - idx] % MOD;
            
            count = (count + dp[1][idx]) % MOD;
        }
        return count;
    }
}