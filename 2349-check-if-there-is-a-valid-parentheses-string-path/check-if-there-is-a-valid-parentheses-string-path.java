class Solution {

    int[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if ((n + m - 1) % 2 != 0)
            return false;

        if (grid[0][0] == ')')
            return false;

        int len = n + m - 1;

        dp = new int[n][m][len + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <= len; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, 0, grid) == 1;
    }

    int solve(int row, int col, int balance, char[][] grid) {

        if (balance < 0)
            return 0;

        if (row >= grid.length || col >= grid[0].length)
            return 0;

        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0)
            return 0;

        if (row == grid.length - 1 &&
                col == grid[0].length - 1) {

            return balance == 0 ? 1 : 0;
        }

        if (dp[row][col][balance] != -1)
            return dp[row][col][balance];

        int right = solve(row, col + 1, balance, grid);

        int down = solve(row + 1, col, balance, grid);

        return dp[row][col][balance] = (right == 1 || down == 1) ? 1 : 0;
    }
}