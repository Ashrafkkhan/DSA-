/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Pair {
        Node node;
        int hd; 

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        if (root == null)
            return null;

        // Stores the first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair current = queue.poll();

            Node node = current.node;
            int hd = current.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
            
        }
        ArrayList<Integer> res=new ArrayList<>();
        for (int value : map.values()) {
            res.add(value);
        }
        return res;

    }
}
