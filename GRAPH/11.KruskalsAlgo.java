//! Code : Kruskal's Algorithm

// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
// Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

//? For printing MST follow the steps -
// 1. In one line, print an edge which is part of MST in the format - 
// v1 v2 w
// where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
// 2. Print V-1 edges in above format in different lines.
// Note : Order of different edges doesn't matter.
// Input Format :
// Line 1: Two Integers V and E (separated by space)
// Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
// Output Format :
// Print the MST, as described in the task.
//? Constraints :
// 2 <= V, E <= 10^5
// Time Limit: 1 sec
//? Sample Input 1 :
// 4 4
// 0 1 3
// 0 3 5
// 1 2 1
// 2 3 8
//? Sample Output 1 :
// 1 2 1
// 0 1 3
// 0 3 5



import java.util.*;

class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int weight;
	
	public Edge(int v1, int v2,int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
}

public class KruskalsAlgo {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		
		Edge edges[] = new Edge[e];
		for (int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			
			Edge edge = new Edge(v1, v2, weight);
			edges[i] = edge;
		}
		
		Edge mst[] = kuskalAlgorithm(edges,n);
		
		for (int i = 0; i < mst.length; i++) {
			if(mst[i].v1 < mst[i].v2)
				System.out.println(mst[i].v1+" "+mst[i].v2+" "+mst[i].weight);
			else
				System.out.println(mst[i].v2+" "+mst[i].v1+" "+mst[i].weight);
		}
	}
    
    public static Edge[] kuskalAlgorithm(Edge[] edges, int n) {
		Arrays.sort(edges);
		
		Edge[] mst = new Edge[n-1];
		int parent[] = new int[n];
		for (int k = 0; k < parent.length; k++) {
			parent[k] = k;
		}
		
		int count=0, i =0;
		while(count != n-1) {
			Edge currEdge = edges[i++];
			int v1parent = findparent(currEdge.v1,parent);
			int v2parent = findparent(currEdge.v2,parent);
			
			if(v1parent != v2parent) {
				mst[count] = currEdge;
				count++;
				parent[v1parent] = v2parent;
			}
		}
		return mst;
	}

	private static int findparent(int v, int[] parent) {

		if( v == parent[v])
			return v;
		return findparent(parent[v], parent);
	}
    
}
