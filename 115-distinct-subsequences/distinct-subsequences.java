class Solution {
    public int numDistinct(String s1, String s2) {
         int m = s1.length();
        int n = s2.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            int temp[] = new int[n + 1];
            temp[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1] + dp[j];
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }
        return dp[n];
    }
}