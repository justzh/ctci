import java.util.ArrayList;

public class Node {
    int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Node)) {
            return false;
        }

        Node n = (Node) o;

        return this.val == n.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

}
