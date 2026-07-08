class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {

        int MOD = 1_000_000_007;

        int n = s.length();

        int[] prefix = new int[n + 1];    
        int[] cnt = new int[n + 1];         
        long[] val = new long[n + 1];       
        long[] pow = new long[n + 1];      

        pow[0] = 1;

        for (int i = 1; i <= n; i++) {

            int digit = s.charAt(i - 1) - '0';

            prefix[i] = prefix[i - 1] + digit;

            cnt[i] = cnt[i - 1];

            if (digit == 0) {
                val[i] = val[i - 1];
            } else {
                cnt[i]++;
                val[i] = (val[i - 1] * 10 + digit) % MOD;
            }

            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int sum = prefix[r] - prefix[l];

            int len = cnt[r] - cnt[l];

            long num = (val[r] - (val[l] * pow[len]) % MOD + MOD) % MOD;

            res[i] = (int) (num * sum % MOD);
        }

        return res;
    }
}