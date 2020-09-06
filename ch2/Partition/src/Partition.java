/*
    Input: List
            Partition value
    Output: partitioned list

    99% sure this works
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String list = br.readLine();
        String[] elements = list.trim().split("\\s+");
        int[] a = new int[elements.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(elements[i]);
        }
        String partition = br.readLine();
        int p = Integer.parseInt(partition);

        Node head = createLinkedList(a);

        partition(head, p);

        printLinkedList(head);
    }

    public static Node createLinkedList(int[] input) {
        Node head = new Node(input[0]);
        Node curr = head;

        for (int i = 1; i < input.length; i++) {
            curr.next = new Node(input[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void partition(Node n, int partition) {
        Node i = n;
        Node j = n;
        while (i != null && j != null) {
            if (i.val < partition) {
                int temp = i.val;
                i.val = j.val;
                j.val = temp;
                j = j.next;
            }
            i = i.next;
        }
    }

    public static void printLinkedList(Node n) {
        Node curr = n;
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
