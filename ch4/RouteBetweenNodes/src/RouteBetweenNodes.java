import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);

        boolean result1 = routeBetweenNodes(1, 3, g);
        boolean result2 = routeBetweenNodes(1, 4, g);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static boolean routeBetweenNodes(int a, int b, Graph g) {
        Node n1 = new Node(a);
        Node n2 = new Node(b);

        // Breadth-first search
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        visited.add(n1);
        queue.add(n1);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node n : g.adjacencyList.get(temp)) {
                if (!visited.contains(n)) {
                    // If target node is found, immediately return
                    if (n.equals(n2)) {
                        return true;
                    }
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

        return false;
    }
}
