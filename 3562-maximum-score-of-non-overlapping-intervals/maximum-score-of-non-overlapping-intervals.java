class Solution {

    int[][] interval;
    int[] nextIdx;
    int n;

    Node[][] dp;

    static class Node {
        long score = 0;
        List<Integer> list = new ArrayList<>();
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        interval = new int[n][4];
        nextIdx = new int[n];

        int idx = 0;

        for (List<Integer> ls : intervals) {
            interval[idx][0] = ls.get(0);
            interval[idx][1] = ls.get(1);
            interval[idx][2] = ls.get(2);
            interval[idx][3] = idx;
            idx++;
        }

        Arrays.sort(interval, (a, b) -> {

            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            if (a[2] != b[2])
                return Integer.compare(a[2], b[2]);

            return Integer.compare(a[3], b[3]);
        });

        for (int i = 0; i < n; i++) {
            nextIdx[i] = find(interval[i][1]);
        }

        dp = new Node[n][5];

        Node ans = solve(0, 4);

        int[] result = new int[ans.list.size()];

        for (int i = 0; i < ans.list.size(); i++) {
            result[i] = ans.list.get(i);
        }

        return result;
    }

    public int find(int val) {

        int low = 0;
        int high = n - 1;
        int res = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (interval[mid][0] > val) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public Node solve(int idx, int k) {

        if (idx == n || k == 0) {
            return new Node();
        }

        if (dp[idx][k] != null) {
            return dp[idx][k];
        }

        Node skip = solve(idx + 1, k);

        Node takeNext = solve(nextIdx[idx], k - 1);

        Node take = new Node();

        take.score = (long) interval[idx][2] + takeNext.score;

        take.list = new ArrayList<>(takeNext.list);
        take.list.add(interval[idx][3]);

        Collections.sort(take.list);

        Node result;

        if (skip.score > take.score) {

            result = skip;

        } else if (skip.score < take.score) {

            result = take;

        } else {

            if (isLexicographicallySmaller(skip.list, take.list)) {
                result = skip;
            } else {
                result = take;
            }
        }

        return dp[idx][k] = result;
    }

    public boolean isLexicographicallySmaller(List<Integer> a,List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (a.get(i) < b.get(i))
                return true;

            if (a.get(i) > b.get(i))
                return false;
        }

        return a.size() < b.size();
    }
}