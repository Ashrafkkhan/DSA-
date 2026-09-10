import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BuildTreeSolution {

    // Map to quickly look up an element's index in the inorder array in O(1)
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        // Store value -> index mappings for fast inorder lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildSubtree(
            inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1
        );
    }

    private TreeNode buildSubtree(
        int[] inorder, int inStart, int inEnd,
        int[] postorder, int postStart, int postEnd
    ) {
        // Base case: no elements left in the current subtree
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 1. The root of the current subtree is the last element in postorder range
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 2. Find the root's index in the inorder array
        int rootIndexInOrder = inorderMap.get(rootVal);

        // 3. Count how many nodes belong to the left subtree
        int leftSubtreeSize = rootIndexInOrder - inStart;

        // 4. Recursively build left and right subtrees
        // Left subtree boundaries:
        //   Inorder:   [inStart, rootIndexInOrder - 1]
        //   Postorder: [postStart, postStart + leftSubtreeSize - 1]
        root.left = buildSubtree(
            inorder, inStart, rootIndexInOrder - 1,
            postorder, postStart, postStart + leftSubtreeSize - 1
        );

        // Right subtree boundaries:
        //   Inorder:   [rootIndexInOrder + 1, inEnd]
        //   Postorder: [postStart + leftSubtreeSize, postEnd - 1]
        root.right = buildSubtree(
            inorder, rootIndexInOrder + 1, inEnd,
            postorder, postStart + leftSubtreeSize, postEnd - 1
        );

        return root;
    }


    }
}
