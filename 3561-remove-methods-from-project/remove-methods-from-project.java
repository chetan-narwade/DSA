class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];

        List<Integer> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean isRemove = false;

        // Build graph
        for (int[] nums : invocations) {
            adj.get(nums[0]).add(nums[1]);
            inDegree[nums[1]]++;
        }

        dfs(k, suspicious, adj);

        // Check if any suspicious node has an incoming edge
        // from a non-suspicious node
        for (int[] edge : invocations) {
            if (!suspicious[edge[0]] && suspicious[edge[1]]) {
                isRemove = true;
                break;
            }
        }

        if (isRemove) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        for (int node = 0; node < n; node++) {
            if (!suspicious[node]) {
                result.add(node);
            }
        }

        return result;
    }

    public void dfs(int node, boolean[] suspicious, List<List<Integer>> adj) {

        suspicious[node] = true;

        for (int it : adj.get(node)) {
            if (!suspicious[it]) {
                dfs(it, suspicious, adj);
            }
        }
    }
}