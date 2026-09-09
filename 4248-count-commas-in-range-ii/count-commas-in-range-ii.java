class Solution {
    public long countCommas(long n) {

        long num1 = 1000;
        long num2 = (long) Math.pow(10, 6);
        long num3 = (long) Math.pow(10, 9);
        long num4 = (long) Math.pow(10, 12);
        long num5 = (long) Math.pow(10, 15);

        long res = 0;

        res += Math.max(0, Math.min(n, num2 - 1) - (num1 - 1));
        res += 2 * Math.max(0, Math.min(n, num3 - 1) - (num2 - 1));
        res += 3 * Math.max(0, Math.min(n, num4 - 1) - (num3 - 1));
        res += 4 * Math.max(0, Math.min(n, num5 - 1) - (num4 - 1));

        res += n >= num5 ? 5 : 0;

        return res;
    }
}