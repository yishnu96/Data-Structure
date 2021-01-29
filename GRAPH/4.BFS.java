// Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
// Find the path using BFS and print the shortest path available.

// ? Input Format :
// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
// The following line contain two integers, that denote the value of v1 and v2.
// ? Output Format :
// Print the path from v1 to v2 in reverse order.

// * Sample Input 1 :
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// 1 3
// * Sample Output 1 :
// 3 0 1

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class BFS {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		
		int[][] matrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
		int source = s.nextInt();
		int destination = s.nextInt();
		
		ArrayList<Integer> path = BFSpath(matrix,source,destination);
        if(path == null) 
			System.out.println();
		else {
			for(int i : path) 
				System.out.print(i+" ");
		}
		
	}

	private static ArrayList<Integer> BFSpath(int[][] matrix, int s, int e) {
		
		Queue<Integer> remVertex = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean visited[] = new boolean[matrix.length];
		visited[s] = true;
		remVertex.add(s);
		map.put(s, -1);
		boolean pathFound = false;
		
		while(!remVertex.isEmpty()) {
			int currVetex = remVertex.poll();
			for(int i=0;i<matrix.length;i++) {
				if(matrix[currVetex][i]==1 && !visited[i]) {
					remVertex.add(i);
					visited[i] = true;
					map.put(i, currVetex);
					if(i==e) {
						pathFound = true;
						break;
					}
				}
			}
		}
		
		if(pathFound) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			int currVetex = e;
			while(currVetex!= -1) {
				path.add(currVetex);
				int parent = map.get(currVetex);
				currVetex = parent;
			}
            return path;
		}else
			return null;
	}
}