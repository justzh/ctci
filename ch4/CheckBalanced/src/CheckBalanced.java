public class CheckBalanced {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < 10; i++) {
            bst.add((int) Math.random() * 100);
        }

        System.out.println(checkBalanced(bst));
        System.out.println(checkBalancedV2(bst.root));
    }

    public static boolean checkBalanced(BinarySearchTree bst) {
        return checkBalancedHelper(bst.root);
    }

    public static boolean checkBalancedHelper(Node n) {
        if (n == null) {
            return true;
        }

        boolean balanced = Math.abs(findHeight(n.left) - findHeight(n.right)) <= 1;

        return balanced && checkBalancedHelper(n.left) && checkBalancedHelper(n.right);
    }

    public static int findHeight(Node n) {
        if (n == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (n.left != null) {
            leftHeight = 1;
        }

        if (n.right != null) {
            rightHeight = 1;
        }

        return Math.max(findHeight(n.left) + leftHeight, findHeight(n.right) + rightHeight);
    }

    public static boolean checkBalancedV2(Node n) {
        return findHeightV2(n) != Integer.MIN_VALUE;
    }

    public static int findHeightV2(Node n) {
        if (n == null)
            return -1;

        int leftHeight = findHeightV2(n.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = findHeightV2(n.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}