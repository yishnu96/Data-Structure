//! Dijkstra's Algorithm

// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
// Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
//? Input Format :
// Line 1: Two Integers V and E (separated by space)
// Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
// Output Format :
// For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be separated by a single space.
// Note : Order of vertices in output doesn't matter.

//? Constraints :
// 2 <= V, E <= 10^5
// Time Limit: 1 sec

//* Sample Input 1 :
// 4 4
// 0 1 3
// 0 3 5
// 1 2 1
// 2 3 8
//* Sample Output 1 :
// 0 0
// 1 3
// 2 4
// 3 5

import java.util.Scanner;
public class DijkstaraAlgo {
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
		dijkastra_Algo(adjMatrix);
	}

	private static void dijkastra_Algo(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		distance[0] = 0;
		for (int i = 1; i < n; i++) 
			distance[i] = Integer.MAX_VALUE;
		
		for(int i=0; i<n-1; i++) {
			int minVertex = findMinVertex(visited,distance);
			visited[minVertex] = true;
			for(int j=0; j<n; j++) {
				if(adjMatrix[minVertex][j] > 0 && !visited[j] && adjMatrix[minVertex][j] < Integer.MAX_VALUE) {
					int newDist = distance[minVertex] + adjMatrix[minVertex][j];
					if(newDist < distance[j])
						distance[j] = newDist;
				}
			}
		}
		for(int i=0; i<n; i++)
			System.out.println(i+" "+ distance[i]);
		
	}

	private static int findMinVertex(boolean[] visited, int[] distance) {
		int minVertex = -1;
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i] && (minVertex==-1 || distance[i] < distance[minVertex]))
				minVertex = i;
		}
		return minVertex;
	}
}
