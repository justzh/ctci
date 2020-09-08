import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    Map<Node, ArrayList<Node>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void add(int n) {
        adjacencyList.putIfAbsent(new Node(n), new ArrayList<>());
    }

    public void remove(int n) {
        Node node = new Node(n);
        adjacencyList.values().stream().forEach(e -> e.remove(node));
        adjacencyList.remove(node);
    }

    public void addEdge(int a, int b) {
        Node n1 = new Node(a);
        Node n2 = new Node(b);
        add(n1.val);
        add(n2.val);
        adjacencyList.get(n1).add(n2);
        adjacencyList.get(n2).add(n1);
    }

    public void removeEdge(int a, int b) {
        Node n1 = new Node(a);
        Node n2 = new Node(b);
        ArrayList<Node> l1 = adjacencyList.get(n1);
        ArrayList<Node> l2 = adjacencyList.get(n2);
        if (l1 != null) {
            l1.remove(n2);
        }
        if (l2 != null) {
            l2.remove(n1);
        }
    }
}
