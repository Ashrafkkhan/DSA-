import java.util.*;

class Solution {

    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Add left boundary excluding leaf nodes
    public void addLeft(Node root, ArrayList<Integer> res) {
        Node curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Add all leaf nodes
    public void addLeaf(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        addLeaf(root.left, res);
        addLeaf(root.right, res);
    }

    // Add right boundary in reverse order, excluding leaf nodes
    public void addRight(Node root, ArrayList<Integer> res) {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                st.push(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!st.isEmpty()) {
            res.add(st.pop());
        }
    }

    public ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Root
        if (!isLeaf(root)) {
            result.add(root.data);
        }

        // Left boundary
        addLeft(root, result);

        // All leaf nodes
        addLeaf(root, result);

        // Right boundary in reverse
        addRight(root, result);

        return result;
    }
}
