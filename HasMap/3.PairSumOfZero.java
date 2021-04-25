/*
!               Pair Sum to 0

Given a random integer array A of size N. Find and print the count of pair of elements in the array which 
sum up to 0.
Note: Array A can contain duplicate elements as well.

Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec

Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
*/


import java.util.*;
import java.lang.Math;
public class Solution {
	public static void PairSum(int[] arr, int size) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if(map.containsKey(arr[i]))
			{
				Integer value = map.get(arr[i]);
				map.put(arr[i], value+1);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
        
        for (int key: arr){
            if (map.containsKey(-key)){
               int count=map.get(key)*map.get(-key);//count(key)*count(-key) would give u total no of time u have to print the pair
                while(count-->0){//loop to print the pair
                    System.out.println(Math.min(key,-key)+" "+Math.max(key,-key));
                }
                map.put(key,0);//set key to 0 so u dont duplicate the printing of pairs
            }
        }

	}
}