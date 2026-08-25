class Solution {
    /*
 int helper(int[][] grid, int[][] dp, int i, int j) {

        if (i == 0 && j == 0)
            return grid[0][0];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = helper(grid, dp, i - 1, j);
        int left = helper(grid, dp, i, j - 1);

        if (up != Integer.MAX_VALUE)
            up += grid[i][j];

        if (left != Integer.MAX_VALUE)
            left += grid[i][j];

        return dp[i][j] = Math.min(up, left);
    }
*/
    public int minPathSum(int[][] grid) {
        int n =grid.length;
        int m=grid[0].length;
        int dp[][]=new int [n][m];
        int up,left;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } 
              else if (i == 0) {

                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } 
                else if (j == 0) {
                   
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } 
                else {
                       up = grid[i][j] + dp[i - 1][j];
                     left = grid[i][j] + dp[i][j - 1];

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
        //return helper(grid,dp,n-1,m-1);
    }
}
