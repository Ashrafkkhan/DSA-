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
    HashMap<Integer,Integer>inorderMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(
            inorder, 0, inorder.length - 1,
            preorder, 0, preorder.length - 1
        );
    }
    private TreeNode buildSubtree(
        int[] inorder, int inStart, int inEnd,
        int[] preorder, int preStart, int preEnd
    ) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInOrder = inorderMap.get(rootVal);

        int leftSubtreeSize = rootIndexInOrder - inStart;

        
        root.left = buildSubtree(
            inorder,
            inStart,
            rootIndexInOrder - 1,
            preorder,
            preStart + 1,
            preStart + leftSubtreeSize
        );

        
        root.right = buildSubtree(
            inorder,
            rootIndexInOrder + 1,
            inEnd,
            preorder,
            preStart + leftSubtreeSize + 1,
            preEnd
        );

        return root;
    }

        
    
}
