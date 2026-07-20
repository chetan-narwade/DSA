class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k %= total;

        int[] nums = new int[total];
        int idx = 0;

        // Flatten the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[idx++] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        int start = (total - k) % total;
        idx = start;

        // Build shifted grid
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(nums[idx]);
                idx = (idx + 1) % total;
            }
            res.add(row);
        }

        return res;
    }
}