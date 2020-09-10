public class Successor {
    public static void main(String[] args) {

    }


    // Solution assumes we're traversing starting from root
    public static Node successor(Node node, Node target) {
        if (node == null) {
            return null;
        }

        Node next = successor(node.left, target);
        if (node.equals(target)) {
            if (node.parent != null) {
                if (node.equals(node.parent.left)) {
                    next = node.parent;
                } else {
                    next = node.parent.parent;
                }
            } else {
                if (node.right != null) {
                    Node curr = node.right;
                    while (curr.left != null) {
                        curr = curr.left;
                    }
                    next = curr;
                }
            }
            return next;
        }
        if (next == null)
            next = successor(node.right, target);
        return next;
    }

    // Solution given the node we want to find its next
    public static Node successorV2(Node n) {
        if (n == null) {
            return null;
        }
        if (n.right != null) {
            Node curr = n.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else {
            Node c = n;
            Node p = n.parent;
            while (p != null && p.left != c) {
                p = p.parent;
                c = p;
            }
            return c;
        }
    }
}
