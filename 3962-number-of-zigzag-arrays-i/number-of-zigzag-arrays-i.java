class Solution {
    int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;

        long[][][] t = new long[N + 1][M + 1][2];

        for (int prevVal = 1; prevVal <= M; prevVal++) {
            t[N][prevVal][0] = 1;
            t[N][prevVal][1] = 1;
        }

        for (int i = N - 1; i >= 0; i--) {

            long[] prefDir0 = new long[M + 1];
            long[] prefDir1 = new long[M + 1];

            for (int prevVal = 1; prevVal <= M; prevVal++) {
                prefDir0[prevVal] = (prefDir0[prevVal - 1] + t[i + 1][prevVal][0]) % MOD;
                prefDir1[prevVal] = (prefDir1[prevVal - 1] + t[i + 1][prevVal][1]) % MOD;
            }

            for (int prevVal = 1; prevVal <= M; prevVal++) {
                t[i][prevVal][1] = (prefDir0[M] - prefDir0[prevVal] + MOD) % MOD;
                t[i][prevVal][0] = prefDir1[prevVal - 1];
            }
        }

        long result = 0;
        for (int startVal = 1; startVal <= M; startVal++) {

            result = (result + t[1][startVal][1]) % MOD;

            result = (result + t[1][startVal][0]) % MOD;
        }
        return (int) result;
    }
}