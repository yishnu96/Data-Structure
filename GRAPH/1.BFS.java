// ! BFS
// Send Feedback
// Given an undirected and disconnected graph G(V, E), print its BFS traversal.
// Note:
// 1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
// 2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
// 3. E is the number of edges present in graph G.
// 4. Take graph input in the adjacency matrix.
// 5. Handle for Disconnected Graphs as well
// ? Input Format :
// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
// Output Format :
// Print the BFS Traversal, as described in the task.
// ? Constraints :
// 0 <= V <= 1000
// 0 <= E <= (V * (V - 1)) / 2
// 0 <= a <= V - 1
// 0 <= b <= V - 1

//* Sample Input 1:
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// * Sample Output 1:
// 0 1 3 2


/* Time complexity: O(V + E) 
    Space complexity: O(V^2) 
    where V is the number of vertices in the input graph and 
    E is the number of edges in the input graph */ 
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 

public class BFS 
{ 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    public static void printBFSHelper(int edges[][], int sv, boolean visited[]) 
    { 
        Queue<Integer> queue = new LinkedList<>(); visited[sv] = true; 
        queue.add(sv); while(!queue.isEmpty()) { 
            int front = queue.remove(); System.out.print(front + " "); 
            for(int i = 0; i < edges.length; i++) { 
                if(edges[front][i] == 1 && !visited[i]) { 
                    visited[i] = true; queue.add(i); 
                } 
            } 
        } 
    } 

    public static void printBFS(int edges[][]) { 
        boolean visited[] = new boolean[edges.length]; 
        for(int i = 0; i < visited.length; i++) { 
            if(!visited[i]) { 
                printBFSHelper(edges, i, visited); 
            } 
        }
    } 
    
    public static void main(String[] args) throws NumberFormatException, IOException { 
        String[] strNums; strNums = br.readLine().split("\\s"); 
        int n = Integer.parseInt(strNums[0]); 
        int e = Integer.parseInt(strNums[1]); 
        if (n==0) { 
            return; 
        } 
        int edges[][] = new int[n][n]; 
        for (int i = 0; i < e; i++) { 
            String[] strNums1; 
            strNums1 = br.readLine().split("\\s"); 
            int fv = Integer.parseInt(strNums1[0]); 
            int sv = Integer.parseInt(strNums1[1]); 
            edges[fv][sv] = 1; edges[sv][fv] = 1; 
        } 
        printBFS(edges); 
    } 
}