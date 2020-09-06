import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumLists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1 = br.readLine();
        String[] vals = num1.trim().split("\\s+");
        int[] a = new int[vals.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(vals[i]);
        }
        String num2 = br.readLine();
        vals = num2.trim().split("\\s+");
        int[] b = new int[vals.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(vals[i]);
        }

        Node nodeA = createLinkedList(a);
        Node nodeB = createLinkedList(b);

        Node nodeC = sumLists(nodeA, nodeB);
        Node nodeD = sumListsForward(nodeA, nodeB);

        printLinkedList(nodeC);
        printLinkedList(nodeD);
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

    public static Node sumLists(Node a, Node b) {
        Node result = new Node((a.val + b.val) % 10);
        Node curr = result;
        int carry = (a.val + b.val) / 10;
        a = a.next;
        b = b.next;

        while (a != null || b != null) {
            int aVal = 0;
            int bVal = 0;
            if (a != null) {
                aVal = a.val;
            }
            if (b != null) {
                bVal = b.val;
            }
            curr.next = new Node((aVal + bVal + carry) % 10);
            carry = (aVal + bVal + carry) / 10;

            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
            curr = curr.next;
        }

        if (carry != 0) {
            curr.next = new Node(carry);
        }

        return result;
    }

    public static Node sumListsForward(Node a, Node b) {
        Node result;
        Node curr;

        int lengthA = getLength(a);
        int lengthB = getLength(b);

        int value = 0;

        int diff = Math.abs(lengthA - lengthB);
        int[] leading = new int[diff + 1];
        Node longer;
        Node other;

        if (lengthA > lengthB) {
            longer = a;
            other = b;
        } else {
            longer = b;
            other = a;
        }

        int carry = 0;

        for (int i = diff; i >= 0; i--) {
            curr = longer;

            for (int j = 0; j < i; j++) {
                leading[i] = curr.val;
                curr = curr.next;
            }

            if (i == diff) {
                carry = (curr.val + other.val + carry) / 10;
            } else {
                carry = (curr.val + carry) / 10;
            }

            leading[i] = (leading[i] + carry) % 10;
        }

        result = new Node(leading[0]);
        curr = result;
        for (int i = 1; i < leading.length; i++) {
            curr.next = new Node(leading[i]);
            curr = curr.next;
        }

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }

        while (longer != null || other != null) {
            int temp = (longer.val + other.val) % 10;
            longer = longer.next;
            other = other.next;
            if (longer != null && other != null) {
                temp += (longer.val + other.val) / 10;
            }
            curr.next = new Node(temp);
            curr = curr.next;
        }

        return result;
    }

    public static int getLength(Node n) {
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
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
