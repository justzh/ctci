public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) <= list.get(i-1))
                return false;
        }
        return true;
    }
    
    private static void inorder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        
        return;
    }
}
