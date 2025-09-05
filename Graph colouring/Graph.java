import java.util.*;

public class Graph {
    private ArrayList<Vertex> vertices;
    private int maxDegree;
    
    public Graph() {
        vertices = new ArrayList<>();
        maxDegree = 0;
    }
    
    public void addVertex(int vertexNumber) {
        vertices.add(new Vertex(vertexNumber));
    }
    
    public void addEdge(int from, int to) {
        getVertex(from).addEdge(to);
        getVertex(to).addEdge(from);
        
        // Update max degree
        maxDegree = Math.max(maxDegree, getVertex(from).getDegree());
        maxDegree = Math.max(maxDegree, getVertex(to).getDegree());
    }
    
    public Vertex getVertex(int vertexNumber) {
        for (Vertex vertex : vertices) {
            if (vertex.getVertexNumber() == vertexNumber) {
                return vertex;
            }
        }
        return null;
    }
    
    public int getBiggestVertex() {
        int maxDegree = -1;
        int selectedVertex = -1;
        
        for (Vertex vertex : vertices) {
            if (vertex.getColour() == -1) { // Only consider uncoloured vertices
                if (vertex.getDegree() > maxDegree || 
                   (vertex.getDegree() == maxDegree && 
                    (selectedVertex == -1 || vertex.getVertexNumber() < selectedVertex))) {
                    maxDegree = vertex.getDegree();
                    selectedVertex = vertex.getVertexNumber();
                }
            }
        }
        
        return selectedVertex;
    }
    
    public void colorGraph() {
        int vertexToColor;
        while ((vertexToColor = getBiggestVertex()) != -1) {
            getVertex(vertexToColor).setColor(maxDegree + 1, this);
        }
    }
    
    public void printVerticesWithColors() {
        // Sort vertices by vertex number for consistent output
        vertices.sort((a, b) -> Integer.compare(a.getVertexNumber(), b.getVertexNumber()));
        
        for (Vertex vertex : vertices) {
            System.out.println(vertex.getVertexNumber() + ":" + vertex.getColour());
        }
    }
    
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
}