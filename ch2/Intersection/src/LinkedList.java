public class LinkedList {
    Node head;
    Node tail;

    public LinkedList(Node head) {
        this.head = head;
        this.tail = head;
    }

    public void insert(Node n) {
        tail.next = n;
        tail = tail.next;
    }

    public void insert(int i) {
        tail.next = new Node(i);
        tail = tail.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node curr = head;
        while (curr != null) {
            sb.append(curr.val + " ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
