class Solution {
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, i, j, shape);
                    set.add(shape.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(char[][] grid, int r, int c, int br, int bc, StringBuilder shape) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1')
            return;

        grid[r][c] = '0';
        shape.append(r - br).append(':').append(c - bc).append(',');

        dfs(grid, r + 1, c, br, bc, shape);
        dfs(grid, r - 1, c, br, bc, shape);
        dfs(grid, r, c + 1, br, bc, shape);
        dfs(grid, r, c - 1, br, bc, shape);
    }
}
