/*

!               Maximum Frequency Number

You are given an array of integers that contain numbers in random order. Write a program to find and return 
the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote 
it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains most frequent element in the given array.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec

Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2

Sample Input 2 :
3
1 4 5
Sample Output 2 :
1
*/

import java.util.ArrayList;
import java.util.HashMap;


public class Solution {

	public static int maxFrequencyNumber(int[] arr){

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> frequency = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if(map.containsKey(arr[i]))
			{
				Integer value = map.get(arr[i]);
				map.put(arr[i], value+1);
			}
			else
			{
				map.put(arr[i], 1);
				frequency.add(arr[i]);
			}
		}
		
		int k=0,max=0,value=0;
		for( Integer i : frequency)
		{
			k = map.get(i);

			if(k>max) {
				max = k;
				value =i;
			}
			
		}
		
		return value ;
	}
}