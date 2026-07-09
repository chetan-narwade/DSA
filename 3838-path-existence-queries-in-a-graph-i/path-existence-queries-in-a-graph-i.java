class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU obj = new DSU(n);

        for (int i = 1; i < n; i++) {
            
            if (nums[i] - nums[i - 1] <= maxDiff) {
                obj.put(i - 1, i);
            }
        }

        boolean res[] = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = obj.getParent(queries[i][0]) == obj.getParent(queries[i][1]);
        }

        return res;
    }
}

class DSU {
    List<Integer> parent;
    List<Integer> rank;

    DSU(int n) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(1);
        }
    }

    public int getParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int temp = getParent(parent.get(node));
        parent.set(node, temp);
        return temp;
    }

    public void put(int u, int v) {
        int parU = getParent(u);
        int parV = getParent(v);

        if (parU == parV)
            return;

        if (rank.get(parU) < rank.get(parV)) {
            parent.set(parU, parV);
        } else if (rank.get(parU) > rank.get(parV)) {
            parent.set(parV, parU);
        } else {
            parent.set(parV, parU);
            rank.set(parU, rank.get(parU) + 1);
        }
    }
}