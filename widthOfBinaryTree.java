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
        long nums;

        Pair(TreeNode node, long nums) {
            this.node = node;
            this.nums = nums;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            long min = q.peek().nums;
            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();

                TreeNode node = current.node;

                long index = current.nums - min;

                if (i == 0) {
                    first = index;
                }

                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            ans = Math.max(ans, (int) (last - first + 1));
        }

        return ans;
    }
}
