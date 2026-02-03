class Solution {
    void path(int [][]maze, int r,int c,ArrayList<String> list,String s){
        int n=maze.length;
       if (r < 0 || c < 0 || r >= n || c >= n || maze[r][c] == 0) {
            return;
        }

        
        if (r == n - 1 && c == n - 1) {
            list.add(s);
            return;
        }
        if(maze[r][c]==0){
            return;
        }
        maze[r][c] = 0;
           path(maze, r + 1, c, list, s + "D"); 
        path(maze, r, c - 1, list, s + "L"); 
        path(maze, r, c + 1, list, s + "R"); 
        path(maze, r - 1, c, list, s + "U");
         maze[r][c] = 1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
       ArrayList<String> list = new ArrayList<>();
        if (maze[0][0] == 0) return list;
        path(maze, 0, 0, list, "");
        return list;
    }
}
