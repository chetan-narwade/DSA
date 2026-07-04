class Solution {
    int result=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : roads) {
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        
        boolean[] visited = new boolean[n+1];
        dfs(adj,1,visited);
        return result;
    }

    public void dfs(ArrayList<ArrayList<int[]>> adj, int curr, boolean[] visited) {
        visited[curr]=true;
        
        for(int[] neigh: adj.get(curr)) {
            int v=neigh[0];
            int wt=neigh[1];

            result=Math.min(result,wt);

            if(!visited[v]) {
                dfs(adj,v,visited);
            }
        }
    }
}