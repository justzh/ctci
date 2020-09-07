/*
 * Input: Two singly linked lists
 * Output: the intersecting node, or null if there isn't one
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intersection {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String line = br.readLine();
//        String[] str = line.trim().split("\\s+");
//        int[] a = new int[str.length];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = Integer.parseInt(str[i]);
//        }
//        line = br.readLine();
//        str = line.trim().split("\\s+");
//        int[] b = new int[str.length];
//        for (int i = 0; i < b.length; i++) {
//            b[i] = Integer.parseInt(str[i]);
//        }
//
//
//
//        Node head1 = createLinkedList(a);
//        Node head2 = createLinkedList(b);

        LinkedList list1 = new LinkedList(new Node(1));
        LinkedList list2 = new LinkedList(new Node(1));

        Node n = new Node(2);
        list1.insert(n);
        list2.insert(n);

        Node intersection = intersects(list1, list2);

        if (intersection != null) {
            System.out.println(intersection.val);
        }
        else {
            System.out.println(intersection);
        }
    }

    public static Node createLinkedList(int[] a) {
        Node head = new Node(a[0]);
        Node curr = head;
        for (int i = 1; i < a.length; i++) {
            curr.next = new Node(a[i]);
            curr = curr.next;
        }
        return head;
    }

    public static Node intersects(LinkedList list1, LinkedList list2) {
        Node result = null;

        Node a = list1.head;
        Node b = list2.head;

        while (a.next != null) {
            a = a.next;
        }

        while (b.next != null) {
            b = b.next;
        }

        if (a == b) {
            int len1 = len(list1.head);
            int len2 = len(list2.head);

            int diff = Math.abs(len1 - len2);

            a = list1.head;
            b = list2.head;
            if (len1 > len2) {
                for (int i = 0; i < diff; i++) {
                    a = a.next;
                }
            } else {
                for (int i = 0; i < diff; i++) {
                    b = b.next;
                }
            }

            while (a != null || b != null) {
                if (a == b) {
                    result = a;
                    break;
                }
                a = a.next;
                b = b.next;
            }
        }

        return result;
    }

    public static int len(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
