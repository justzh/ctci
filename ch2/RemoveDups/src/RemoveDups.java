/* Remove Dups: Write code to remove duplicates from an unsorted linked list.
   FOLLOW UP
   How would you solve this problem if a temporary buffer is not allowed?

   Input: Numbers?
   Output: LinkedList
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RemoveDups {
    public static void main(String[] args) throws IOException {
        int input[] = readInput();

        Node head = createLinkedList(input);

        removeDups(head);

        printLinkedList(head);
    }

    public static int[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");

        int nums[] = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        return nums;
    }

    public static Node createLinkedList(int[] nums) {
        Node first = new Node(nums[0]);
        Node curr = first;

        for (int i = 1; i < nums.length; i++) {
            curr.next = new Node(nums[i]);
            curr = curr.next;
        }

        return first;
    }

    public static void removeDups(Node head) {
        Node i = head;
        Node j = head.next;

        while (i != null) {
            while (j != null) {
                if (i.val == j.val) {
                    i.next = j.next;
                }
                j = j.next;
            }
            i = i.next;
            if (i != null) {
                j = i.next;
            }
        }
    }

    public static void printLinkedList(Node n) {
        Node currNode = n;
        while (currNode != null) {
            if (currNode.next == null) {
                System.out.print(currNode.val + "\n");
            }
            else {
                System.out.print(currNode.val + " ");
            }
            currNode = currNode.next;
        }
    }
}