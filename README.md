# Graph-Coloring-in-Java
Graph coloring is the process of assigning colors (represented as integers) to vertices of a graph such that no two adjacent vertices share the same color. This program uses a greedy heuristic.

⚙️ How It Works

The program is split into three classes:

Program → Handles input, creates the graph, and runs the coloring algorithm.

Graph → Stores vertices, edges, and handles the coloring logic.

Vertex → Represents a node with adjacency and color information.

Algorithm Steps:
Read number of vertices.
Add vertices to the graph.
Read edges (until -1 is entered).
Pick the highest-degree uncolored vertex.
Assign the smallest available color.
Repeat until all vertices are colored.

📥 Input Format
First line: number of vertices n.
Next lines: edges in the form from,to.
End input with -1.

Example Input:
5
0,1
0,2
1,2
1,3
3,4
-1

Output Format:
vertexNumber:color

Example Output:
0:0
1:1
2:2
3:0
4:1

🌍 Practical Uses of Graph Coloring

Scheduling: Assigning non-conflicting time slots.
Register allocation: Optimizing CPU register use.
Map coloring: Distinguishing regions without overlap.
Network frequency assignment: Avoiding interference.
