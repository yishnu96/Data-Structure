// ! Get Path - DFS

// Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
// Find the path using DFS and print the first path that you encountered.
// Note:
// 1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
// 2. E is the number of edges present in graph G.
// 3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
// 4. Save the input graph in Adjacency Matrix.
// Input Format :
// The first line of input contains two integers, that denote the value of V and E.
// Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
// The following line contain two integers, that denote the value of v1 and v2.
// Output Format :
// Print the path from v1 to v2 in reverse order.
// Constraints :
// 2 <= V <= 1000
// 1 <= E <= (V * (V - 1)) / 2
// 0 <= a <= V - 1
// 0 <= b <= V - 1
// 0 <= v1 <= 2^31 - 1
// 0 <= v2 <= 2^31 - 1
// Time Limit: 1 second
// Sample Input 1 :
// 4 4
// 0 1
// 0 3
// 1 2
// 2 3
// 1 3
// Sample Output 1 :
// 3 0 1


import java.util.ArrayList; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.*;

public class DFS { 


    private static ArrayList<Integer> getPathDFS(int [][]edges,int v1,int v2,boolean[] visited){
        if(v1==v2){
            ArrayList<Integer> v=new ArrayList<>();
            v.add(v1);
            return v;
        }
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            visited[v1]=true;
            if(i==v1){
                continue;
            }
            if(edges[v1][i]==1&&!visited[i]){
                a=getPathDFS(edges,i,v2,visited);
                if(a.size()!=0){
                    a.add(v1);
                    return a;
                }
            }
        }
        if(a.size()==0){
            return a;
        }
        a.add(v1);
        return a;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int [][] edges=new int[V][V];
        for(int i=0;i<E;i++){
            int fi=s.nextInt();
            int ei=s.nextInt();
            edges[fi][ei]=1;
            edges[ei][fi]=1;
        }
        int v1=s.nextInt();
        int v2=s.nextInt();
        boolean[]visited=new boolean[V];

        ArrayList<Integer> ans=getPathDFS(edges,v1,v2,visited);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}