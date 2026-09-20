class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Out of bounds
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return;
        }

        // Water or already visited
        if (grid[r][c] != '1') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Explore 4 directions
        dfs(grid, r + 1, c); // down
        dfs(grid, r - 1, c); // up
        dfs(grid, r, c + 1); // right
        dfs(grid, r, c - 1); // left
    }
}
