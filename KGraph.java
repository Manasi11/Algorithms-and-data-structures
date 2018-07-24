import java.util.*;
import java.io.*;

//kruskal's algorithm

class KGraph
{
//Edge class represents a single edge in the graph
	class Edge implements Comparable<Edge>
	{
		int src, dest, weight;
		//Comparator function used to sort edges based on weight
		public int compareTo(Edge compareEdge)
		{
			return this.weight-compareEdge.weight;
			}
		};
		//A class to represent a subset for finding union
class subset
	{
	int parent, rank;
	};
	int V, E; // V is number of vertices and E is number of edges
	Edge edge[]; //array of all the edges
	//Create a graph with V vertices and E edges
	
	KGraph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i=0; i<e; ++i)
			edge[i] = new Edge();
		}
//A utility function to find set of an element i using path compression technique
	int find(subset subsets[], int i)
	{
//find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
		}

//A function that does union of two sets of x and y
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		//Attach smaller rank tree under root of high rank tree
		//(Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
//If ranks are same, then make one as root and increment its rank by one
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
			}
		}

//The main function to find Minimum spanning tree using Kruskal's algorithm
	void KruskalMST()
	{
		Edge result[] = new Edge[V]; // Tnis will store the resultant MST
		int e = 0; // An index variable, used for result[]
		int i = 0; // An index variable, used for sorted edges
		for (i=0; i<V; ++i)
			result[i] = new Edge();
//Step 1: Sort all the edges in non-decreasing order of their weight
		Arrays.sort(edge);
//we will create creating V ssubsets
		subset subsets[] = new subset[V];
		for(i=0; i<V; ++i)
			subsets[i]=new subset();
//Create V subsets with single element
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; // Index used to pick up next edge
//Number of edges to be taken is V-1
		while (e < V - 1)
			{
//Step 2: Pick the smallest edge. And increment the index for the next iteration

				Edge next_edge = new Edge();
				next_edge = edge[i++];
				int x = find(subsets, next_edge.src);
				int y = find(subsets, next_edge.dest);
				//If including this edge does't cause cycle, include it in result and increment the index
				//of result for next edge
				if (x != y)
				{
					result[e++] = next_edge;
					Union(subsets, x, y);
				}
//Else discard the next_edge
		}
//print the contents of result[] to display the built MST

System.out.println("Following are the edges in " + "the constructed MST");
System.out.println("Source \t Destination \t Weight");

for (i = 0; i < e; ++i){
	System.out.println((char)(result[i].src+65)+" \t\t" + (char)(result[i].dest+65)+" \t " + result[i].weight);
}
	int cost = 0;
	for(i = 0; i <= e; i++)
	{
		cost = cost + result[i].weight;
	}
	System.out.println("The minimum cost of Kruskal's Algortihm is: " + cost);
	}

	public static void main (String[] args)throws FileNotFoundException

{
		long starttime;
		long endtime;
	File file = new File("C:/Users/Nirja/Documents/input3.txt");
	Scanner sc = new Scanner(file);
	int V = sc.nextInt(); // Number of vertices in graph
	int E = sc.nextInt(); // Number of edges in graph
	KGraph graph = new KGraph(V, E);
	System.out.println("Given graph:");
	System.out.println("Source \t Destination \t Weight");
	sc.next().charAt(0);
	for(int i=0;i<E;i++)
	{
		int source=(int)sc.next().charAt(0)-65;
		int dest = (int)sc.next().charAt(0)-65;
		int weight = sc.nextInt();
		graph.edge[i].src = source;
		graph.edge[i].dest = dest;
		graph.edge[i].weight = weight;
		
				System.out.println((char)(source+65)+"\t\t "+(char)(dest+65)+"\t"+ weight);
				
	}
	starttime = System.nanoTime();
	graph.KruskalMST();
	endtime = System.nanoTime();
	System.out.println(" ");
	System.out.println("The time taken for execution of Kruskal's Algorithm is " + (endtime-starttime)+" nanoseconds");
	}
}