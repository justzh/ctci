import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] values = line.trim().split("\\s+");
        int[] a = new int[values.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(values[i]);
        }

        Node head = createLinkedList(a);

        boolean isPalindrome = isPalindrome(head);

        System.out.println(isPalindrome);
    }

    public static Node createLinkedList(int[] a) {
        if (a.length == 0) {
            return null;
        }
        Node head = new Node(a[0]);
        Node curr = head;
        for (int i = 1; i < a.length; i++) {
            curr.next = new Node(a[i]);
            curr = curr.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node head) {
        Node curr = head;
        Node reverseHead = null;
        while (curr != null) {
            Node n = new Node(curr.val);
            n.next = reverseHead;
            reverseHead = n;
            curr = curr.next;
        }

        curr = head;
        Node curr2 = reverseHead;
        while (curr != null) {
            if (curr.val != curr2.val) {
                return false;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }

        return true;
    }
}
