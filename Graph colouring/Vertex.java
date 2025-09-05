import java.util.*;

public class Vertex {
    private int vertexNumber;
    private ArrayList<Integer> adjacencyList;
    private int colour;
    
    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.adjacencyList = new ArrayList<>();
        this.colour = -1; // Initialize as uncoloured
    }
    
    public void addEdge(int vertex) {
        adjacencyList.add(vertex);
    }
    
    public int getVertexNumber() {
        return vertexNumber;
    }
    
    public ArrayList<Integer> getAdjacencyList() {
        return adjacencyList;
    }
    
    public int getDegree() {
        return adjacencyList.size();
    }
    
    public int getColour() {
        return colour;
    }
    
    public void setColor(int graphDegree, Graph graph) {
        // Create used array with size equal to graph degree
        int[] used = new int[graphDegree];
        
        // Mark colors used by adjacent vertices
        for (int adjacentVertex : adjacencyList) {
            int adjacentColor = graph.getVertex(adjacentVertex).getColour();
            if (adjacentColor != -1 && adjacentColor < graphDegree) {
                used[adjacentColor] = 1;
            }
        }
        
        // Find the first unused color (smallest available color)
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                this.colour = i;
                return;
            }
        }
    }
}