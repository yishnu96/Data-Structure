// ! 3 Cycle
// Send Feedback
// Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
// Input Format :
// The first line of input contains two space separated integers, that denotes the value of N and M.
// Each of the following M lines contain two integers, that denote the vertices which have an undirected edge between them. Let us denote the two vertices with the symbol u and v. 
// Output Format :
// Print the count the number of 3-cycles in the given graph
// ? Constraints :
// 0 <= N <= 100
// 0 <= M <= (N*(N-1))/2
// 0 <= u <= N - 1
// 0 <= v <= N - 1
// Time Limit: 1 sec
// ? Sample Input 1:
// 3 3
// 0 1
// 1 2
// 2 0
// Sample Output 1:
// 1


public class CycleThree {
    public static int solve(int V, int E, int[] u, int[] v) {
		int[][] matrix = new int[V+1][V+1];

		for (int i = 0; i < E; i++) {
			int k1 = u[i];
			int k2 = v[i];
			matrix[k1][k2] = 1;
			matrix[k2][k1] = 1;
		}
		
		int ans = countTriCycle(matrix);
		return ans;
	}
	private static int countTriCycle(int[][] adjMatrix) {

		int n = adjMatrix.length;
        int count = 0; 
        for(int i = 0; i < n ;i++)
            for(int j = 0; j < n; j++)
                if(adjMatrix[i][j] != 0)
                    for(int k = 0; k < n; k++){
                        if(k!=i && adjMatrix[j][k] != 0 && adjMatrix[i][k] != 0 ){
                             count++;    
                        }
                    }
                
            
        return count/6;
	}
}
