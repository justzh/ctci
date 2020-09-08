// Only allows unique values, no duplicates

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {

    };
    public BinarySearchTree(int val) {
        root = new BSTNode(val);
    }

    public void add(int val) {
        root = addRecursive(root, val);
    }

    public BSTNode addRecursive(BSTNode current, int val) {
        if (current == null) {
            return new BSTNode(val);
        }

        if (val < current.val) {
            current.left = addRecursive(current.left, val);
        } else if (val > current.val) {
            current.right = addRecursive(current.right, val);
        }

        return current;
    }
}
