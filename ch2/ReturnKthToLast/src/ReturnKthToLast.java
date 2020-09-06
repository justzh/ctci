/* Input:
    k
    a b c d e f

    The second line are elements of the LinkedList
    If k is longer than the length of the list, the result will be the value of the head.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReturnKthToLast {
    public static void main(String[] args) throws IOException {
        IntArrayPair input = readInput();
        int k = input.getInt();
        int[] inputArr = input.getArray();
        Node head = createLinkedList(inputArr);
        System.out.println(returnKthToLast(head, k));
    }

    public static IntArrayPair readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String k = br.readLine();
        int kInt = Integer.parseInt(k.trim());
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        int a[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        return new IntArrayPair(kInt, a);
    }

    public static Node createLinkedList(int[] input) {
        Node head = new Node(input[0]);
        Node curr = head;
        for (int i = 1; i < input.length; i++) {
            curr.next = new Node(input[i]);
        }
        return head;
    }

    public static int returnKthToLast(Node head, int k) {
        int length = 0;

        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        curr = head;

        for (int i = 0; curr != null && i < length - k - 1; i++) {
            curr = curr.next;
        }

        return curr.val;
    }
}
