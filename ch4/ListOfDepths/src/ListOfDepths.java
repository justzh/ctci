import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListOfDepths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");

        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < strs.length; i++) {
            bst.add(Integer.parseInt(strs[i]));
        }

        ArrayList<ListNode> results = new ArrayList<>();
        int depth = 0;

        listOfDepths(bst.root, results, depth);

        for (ListNode n: results) {
            print(n);
        }
    }

    public static void listOfDepths(BSTNode node, ArrayList<ListNode> results, int depth) {
        if (node == null) {
            return;
        }
        if (results.size() < depth + 1) {
            results.add(new ListNode(node.val));
        } else {
            ListNode last = results.get(depth);
            while (last.next != null) {
                last = last.next;
            }
            last.next = new ListNode(node.val);
        }

        listOfDepths(node.left, results, depth + 1);
        listOfDepths(node.right, results, depth + 1);
    }

    public static void print(ListNode n) {
        ListNode curr = n;
        while (curr != null) {
            if (curr.next == null) {
                System.out.print(curr.val + "\n");
            } else {
                System.out.print(curr.val + " ");
            }
            curr = curr.next;
        }
    }
}
