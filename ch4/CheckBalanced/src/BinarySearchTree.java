public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
    }

    public void add(int val) {
        root = addRecursive(root, val);
    }

    public Node addRecursive(Node n, int val) {
        if (n == null) {
            return new Node(val);
        }

        if (val < n.val) {
            n.left = addRecursive(n.left, val);
        } else {
            n.right = addRecursive(n.right, val);
        }
        return n;
    }

}
