// Java program to print DFS
import java.io.*;
import java.util.*;
 
class Graph{
    private int V;
 
    //  lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
 
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
 

    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + "  ");
		
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[V];
 
        // function to print DFS traversal
        DFSUtil(v, visited);
    }
    public static void main(String args[])
    {                          
        Graph g = new Graph(6); // No of vertices 6
 
        g.addEdge(2, 0);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(5, 1);
		g.addEdge(2, 5);
		g.addEdge(3, 2);
		g.addEdge(5, 3);
		g.addEdge(4, 3);
		g.addEdge(3, 4);
		
 
        System.out.println( "This DFS is  "+ "(starting from vertex 2)");
		System.out.print( "The DFS for given graph :- ");
 
        g.DFS(2);
    }
}



/*        Graph          (2)   ........................ 0
							/	  \	
						(0)	  (5) .........................1
						/		    \
					(1)			(3)..........................2
										\
										(4)......................3
									    
*/