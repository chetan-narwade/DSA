class Solution {
    int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {

        int n = s.length();

        long[] dp = new long[n + 1];

        dp[n] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = n-1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            dp[i] = (2 * dp[i + 1]) % MOD;

            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch]] + MOD) % MOD;
            }

            last[ch] = i + 1;
        }

        return (int) ((dp[0] - 1 + MOD) % MOD);
    }
}