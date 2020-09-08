/*
 * Input: a sorted (increasing order) array with unique integer elements
 * Output: binary search tree with minimal height
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MinimalTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        int[] ints = new int[strs.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        Node root = helper(0, ints.length - 1, ints);

        print(System.out, root);
    }

    public static Node helper(int l, int r, int[] ints) {
        if (l > r) {
            return null;
        }
        int middle = (l + r) / 2;
        Node n = new Node(ints[middle]);
        n.left = helper(l, middle - 1, ints);
        n.right = helper(middle + 1, r, ints);
        return n;
    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, Node n) {
        if (n != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(n.val);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│ ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (n.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, n.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, n.right);
        }
    }

    public static void print(PrintStream os, Node root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", root);
        os.print(sb.toString());
    }
}
