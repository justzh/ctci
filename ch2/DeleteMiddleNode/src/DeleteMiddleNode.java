/*
    Input: Index of node to be removed
            LinkedList
    Result: LinkedList with removed node

    Note: need to check if index is out of bounds
 */

import java.util.Scanner;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node curr = head;

        while (sc.hasNextInt()) {
            curr.next = new Node(sc.nextInt());
            curr = curr.next;
        }

        Node nodeToBeRemoved = null;

        curr = head;
        int i = 0;
        while (curr.next != null && i <= index) {
            if (i == index) {
                nodeToBeRemoved = curr;
            }
            curr = curr.next;
            i++;
        }

        removeNode(nodeToBeRemoved);

        printLinkedList(head);
    }

    public static void removeNode(Node n) {
        Node curr = n;
        while (curr != null) {
            curr.val = curr.next.val;
            if (curr.next.next == null) {
                curr.next = null;
            }
            curr = curr.next;
        }
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
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
