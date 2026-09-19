class Solution {
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='L'){
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,vis,grid,vec,i,j);
                    set.add(vec);
                 }
            }
        }
        return set.size();
    }

    private void dfs(int r, int c, int vis[][], char grid[][],ArrayList<String> vec ,int r0,int c0){
        vis[r][c]=1;
        vec.add((r-r0)+"-"+(c-c0));
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length 
            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'L') {
                dfs(nrow, ncol, vis, grid, vec, r0, c0);
                    }
        }
    }
}
