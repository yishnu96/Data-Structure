//! Code : Prim's Algorithm

// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
// Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
//? For printing MST follow the steps -
// 1. In one line, print an edge which is part of MST in the format - 
// v1 v2 w
// where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
// 2. Print V-1 edges in above format in different lines.
// Note : Order of different edges doesn't matter.
//? Input Format :
// Line 1: Two Integers V and E (separated by space)
// Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
//? Output Format :
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
// 0 1 3
// 1 2 1
// 0 3 5



import java.util.*;
public class PrimsAlgo {
    public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int[][] adjMatrix= new int[n][n];
		
		for(int i=0;i<e;i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			adjMatrix[v1][v2] = weight;
			adjMatrix[v2][v1] = weight;
		}
		prism(adjMatrix);
	}

	private static void prism(int[][] adjMatrix) {
		
		int n = adjMatrix.length;
		boolean visited[] = new boolean[n];
		int weight[] = new int[n];
		int parent[] = new int[n];
		parent[0] = -1;
		weight[0] = 0;
		
		for(int i = 0;i<n;i++) 
			weight[i] = Integer.MAX_VALUE;
		
		for(int i=0 ; i<n; i++) {
			int minVtx = findMinVertex(visited,weight);
			visited[minVtx] = true;
			for (int j = 0; j < n; j++) {
				if(adjMatrix[minVtx][j] != 0 && !visited[j]) {
					if(weight[j] > adjMatrix[minVtx][j]) {
						
						weight[j] = adjMatrix[minVtx][j];
						parent[j] = minVtx;
					}
				}
			}
		}
		
		for (int i = 1; i < n; i++) {
			if(i<parent[i])
				System.out.println(i+" "+parent[i]+" "+weight[i]);
			else
				System.out.println(parent[i]+" "+i+" "+weight[i]);
		}
	}

	private static int findMinVertex(boolean[] visited, int[] weight) {
		
		int minVtx = -1;
		for (int i = 0; i < visited.length; i++) {
			if( !visited[i] &&(minVtx ==-1 || weight[i] < weight[minVtx]))
				minVtx = i;
		}
		return minVtx;
	}
}
