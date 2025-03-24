import java.util.*;

class GraphColoring {
    private int[][] graph; // Adjacency matrix
    private int[] colors;  // Stores colors assigned to vertices
    private int V;         // Number of vertices

    public GraphColoring(int vertices) {
        V = vertices;
        graph = new int[V][V]; // Initialize graph
        colors = new int[V];   // Initialize color array
    }

    public void addEdge(int src, int dest) {
        graph[src][dest] = 1;
        graph[dest][src] = 1; // Since it's an undirected graph
    }

    public boolean isSafe(int node, int color) {
        for (int i = 0; i < V; i++) {
            if (graph[node][i] == 1 && colors[i] == color) { // If neighbor has the same color
                return false;
            }
        }
        return true;
    }

    public boolean colorGraph(int node, int m) {
        if (node == V) return true; // All nodes are colored

        for (int c = 1; c <= m; c++) { // Try colors from 1 to m
            if (isSafe(node, c)) {
                colors[node] = c; // Assign color

                if (colorGraph(node + 1, m)) return true; // Move to the next node

                colors[node] = 0; // Backtrack if not possible
            }
        }
        return false;
    }

    public void solve(int m) {
        if (colorGraph(0, m)) { // Start coloring from node 0
            System.out.println("Solution Exists! Vertex Colors:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " → Color " + colors[i]);
            }
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static void main(String[] args) {
        GraphColoring g = new GraphColoring(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.solve(3); // Number of colors
    }
}
