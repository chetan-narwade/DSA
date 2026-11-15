
class Solution {
    public int numOfSubarrays(int[] arr) {

        int prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;
        int count = 0;

        int MOD = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum % 2 != 0) {

                count = (count + evenCount) % MOD;
                oddCount++;

            } else {

                count = (count + oddCount) % MOD;
                evenCount++;
            }
        }

        return count;
    }
}