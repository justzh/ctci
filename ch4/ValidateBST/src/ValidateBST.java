public class ValidateBST {
    public static void main(String[] args) {
        // TODO: Input/Output
    }

    public static boolean validateBST(Node node) {
        if (node == null) {
            return true;
        }

        boolean greaterThanLeft = true;
        if (node.left != null) {
            greaterThanLeft = node.val >= node.left.val;
        }

        boolean lessThanRight = true;
        if (node.right != null) {
            lessThanRight = node.val <= node.right.val;
        }

        return greaterThanLeft && lessThanRight && validateBST(node.left) && validateBST(node.right);
    }
}
