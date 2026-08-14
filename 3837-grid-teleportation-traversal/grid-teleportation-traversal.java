class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int minMoves(String[] matrix) {

        int m = matrix.length;
        int n = matrix[0].length();

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        ArrayList<Pair>[] portals = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            portals[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = matrix[i].charAt(j);

                if (ch >= 'A' && ch <= 'Z') {
                    portals[ch - 'A'].add(new Pair(i, j));
                }
            }
        }

        Deque<Pair> dq = new ArrayDeque<>();

        dist[0][0] = 0;
        dq.offerFirst(new Pair(0, 0));

        boolean[] used = new boolean[26];

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            Pair curr = dq.pollFirst();

            int row = curr.row;
            int col = curr.col;

            int currentDist = dist[row][col];

            if (row == m - 1 && col == n - 1) {
                return currentDist;
            }

            char ch = matrix[row].charAt(col);

            if (ch >= 'A' && ch <= 'Z') {

                int index = ch - 'A';

                if (!used[index]) {

                    used[index] = true;

                    for (Pair next : portals[index]) {

                        int nr = next.row;
                        int nc = next.col;

                        if (nr == row && nc == col) {
                            continue;
                        }

                        if (currentDist < dist[nr][nc]) {

                            dist[nr][nc] = currentDist;

                            dq.offerFirst(new Pair(nr, nc));
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {

                int nr = row + dRow[i];
                int nc = col + dCol[i];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                if (matrix[nr].charAt(nc) == '#') {
                    continue;
                }

                if (currentDist + 1 < dist[nr][nc]) {

                    dist[nr][nc] = currentDist + 1;

                    dq.offerLast(new Pair(nr, nc));
                }
            }
        }

        return -1;
    }
}