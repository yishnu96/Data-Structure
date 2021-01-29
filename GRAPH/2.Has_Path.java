// ! Has Path?
// Send Feedback
// Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
// ? Note:
// 1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
// 2. E is the number of edges present in graph G.
// Input Format :
// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
// The following line contain two integers, that denote the value of v1 and v2.
// Output Format :
// The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
// ? Constraints :
// 0 <= V <= 1000
// 0 <= E <= 1000
// 0 <= a <= V - 1
// 0 <= b <= V - 1
// 0 <= v1 <= 2^31 - 1
// 0 <= v2 <= 2^31 - 1
// Time Limit: 1 second
// *Sample Input 1 :
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// 1 3
// *Sample Output 1 :
// true
// *Sample Input 2 :
// 6 3
// 5 3
// 0 1
// 3 4
// 0 3
// *Sample Output 2 :
// false


import java.util.LinkedList; 
import java.util.Queue; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 

public class Has_Path { 
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    public static boolean BFS(int edges[][], int sv, int ev, boolean visited[]) { 
        // Check for invalid input of sv or ev 
        if (sv > (edges.length - 1) || ev > (edges.length - 1) ){
             return false; 
        } 
        if(edges[sv][ev] == 1) { 
            return true; 
        } 
        Queue<Integer> queue = new LinkedList<>(); 
        visited[sv] = true; queue.add(sv); 
        while(!queue.isEmpty()) { 
            int front = queue.remove(); 
            for(int i = 0; i < edges.length; i++) { 
                if(edges[front][i] == 1 && !visited[i]) { 
                    if(i == ev) 
                    return true; 
                    else { 
                        visited[i] = true; 
                        queue.add(i); 
                    } 
                } 
            } 
        } 
        return false; 
    } 
    
    private static boolean hasPath(int[][] edges, int sv, int ev) { 
        boolean visited[] = new boolean[edges.length]; 
        return BFS(edges, sv, ev, visited); 
    } 
    
    public static void main(String[] args) throws NumberFormatException, IOException { 
        String[] strNums; 
        strNums = br.readLine().split("\\s"); 
        int n = Integer.parseInt(strNums[0]); 
        int e = Integer.parseInt(strNums[1]); 
        int edges[][] = new int[n][n]; 

        for (int i = 0; i < e; i++) { 
            String[] strNums1; strNums1 = br.readLine().split("\\s"); 
            int fv = Integer.parseInt(strNums1[0]); 
            int sv = Integer.parseInt(strNums1[1]); 
            edges[fv][sv] = 1; edges[sv][fv] = 1; } 
            String[] strNums1; 
            strNums1 = br.readLine().split("\\s"); 
            int sv = Integer.parseInt(strNums1[0]); 
            int ev = Integer.parseInt(strNums1[1]); 
            System.out.println(hasPath(edges, sv, ev)); 
        } 
}