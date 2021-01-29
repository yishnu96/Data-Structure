// ! isConnected?

// Given an undirected graph G(V,E), check if the graph G is connected graph or not.

// ? Sample Input 1:
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// ? Sample Output 1:
// true

import java.util.Scanner;

public class isConnected {
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
		
		boolean connected = isConnected(matrix);
		
		if(connected)
			System.out.println("true");
		else
			System.out.println("false");
	}

	private static boolean isConnected(int[][] matrix) {
		boolean[] visited = new boolean[matrix.length];
		boolean flag=true;
		dftraversal(matrix,0,visited);
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])
				flag=false;
		}
		
		if(flag)
			return true;
		else 
			return flag;
	}

	private static void dftraversal(int[][] matrix, int currVtx, boolean[] visited) {
		visited[currVtx] =true;
//		System.out.print(currVtx+" ");
		
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[currVtx][i]==1 && !visited[i])
				dftraversal(matrix, i, visited);
			
		}
		
	}
}