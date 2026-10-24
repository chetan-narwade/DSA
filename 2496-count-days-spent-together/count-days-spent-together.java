class Solution {
    int[] dp = { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int arriveA = dp[Integer.parseInt(arriveAlice.substring(0, 2))] + Integer.parseInt(arriveAlice.substring(3));

        int leaveA = dp[Integer.parseInt(leaveAlice.substring(0, 2))] + Integer.parseInt(leaveAlice.substring(3));

        int arriveB = dp[Integer.parseInt(arriveBob.substring(0, 2))] + Integer.parseInt(arriveBob.substring(3));

        int leaveB = dp[Integer.parseInt(leaveBob.substring(0, 2))] + Integer.parseInt(leaveBob.substring(3));

        int start = Math.max(arriveA, arriveB);
        int end = Math.min(leaveA, leaveB);

        return Math.max(0, end - start + 1);
    }
}