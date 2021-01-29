//! Islands
// An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.
// Input Format :
// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b. 
// Output Format :
// Print the count the number of connected groups of islands
//? Constraints :
// 0 <= V <= 1000
// 0 <= E <= (V * (V-1)) / 2
// 0 <= a <= V - 1
// 0 <= b <= V - 1
// Time Limit: 1 second
//? Sample Input 1:
// 5 8
// 0 1
// 0 4
// 1 2
// 2 0
// 2 4
// 3 0
// 3 2
// 4 3
//? Sample Output 1:
// 1 

public class NumberOfisLand {
    
    public static int solve(int V, int E, int[] u, int[] v) {
		
		int[][] matrix = new int[V+1][V+1];
		
		for (int i = 0; i < E; i++) {
			int k1 = u[i];
			int k2 = v[i];
			matrix[k1][k2] = 1;
			matrix[k2][k1] = 1;
		}
		
		boolean[] visited = new boolean[V+1];
		int i=1, count = 0;
		while(i<=V) {
			if(!visited[i]) {
				count++;
				dftraversal(matrix,i,visited);
				i=1;
			}
			else
				i++;
		}
		return count;
	}

	private static void dftraversal(int[][] matrix, int currVtx, boolean[] visited) {
		visited[currVtx] =true;
		for (int i = 1; i < matrix.length; i++) {
			if(matrix[currVtx][i]==1 && !visited[i])
				dftraversal(matrix, i, visited);	
		}
	}
}