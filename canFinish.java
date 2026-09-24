class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
         for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        // Cycle found
        if (state[course] == 1) {
            return false;
        }

        // Already completely processed
        if (state[course] == 2) {
            return true;
        }

        // Mark as currently visiting
        state[course] = 1;

        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // Mark as completely processed
        state[course] = 2;

        return true;
    }

        
    
}
