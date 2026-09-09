/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int level;
        int vertical;

        Pair(TreeNode node, int level, int vertical) {
            this.node = node;
            this.level = level;
            this.vertical = vertical;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();

            TreeNode node = current.node;
            int level = current.level;
            int vertical = current.vertical;

            map.putIfAbsent(vertical, new TreeMap<>());

            map.get(vertical).putIfAbsent(
                level,
                new PriorityQueue<>()
            );

            map.get(vertical)
               .get(level)
               .offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(
                    node.left,
                    level + 1,
                    vertical - 1
                ));
            }

            if (node.right != null) {
                q.offer(new Pair(
                    node.right,
                    level + 1,
                    vertical + 1
                ));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : levels.values()) {

                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            res.add(column);
        }

        return res;
    }
}
