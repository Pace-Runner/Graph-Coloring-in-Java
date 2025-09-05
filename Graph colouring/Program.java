import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        
        // Read number of vertices
        int numVertices = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Add vertices to graph
        for (int i = 0; i < numVertices; i++) {
            graph.addVertex(i);
        }
        
        // Read edges
        String line;
        while (!(line = scanner.nextLine()).equals("-1")) {
            String[] parts = line.split(",");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.addEdge(from, to);
        }
        
        // Color the graph
        graph.colorGraph();
        
        // Print results
        graph.printVerticesWithColors();
        
        scanner.close();
    }
}