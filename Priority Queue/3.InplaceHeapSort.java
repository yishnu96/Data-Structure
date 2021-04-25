/*
!           Inplace Heap Sort

Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2
*/


public class Solution {

	public static void inplaceHeapSort(int[] arr) {

		int n = arr.length; 

		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i); 

		for (int i=n-1; i>0; i--) 
		{ 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			heapify(arr, i, 0); 
		} 
	}

	private static void heapify(int[] arr, int n, int i) {
		
	       int largest = i;
	        int l = 2*i + 1; 
	        int r = 2*i + 2; 
	  
	        if (l < n && arr[l] < arr[largest]) 
	            largest = l; 
	  
	        if (r < n && arr[r] < arr[largest]) 
	            largest = r; 
	  
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            heapify(arr, n, largest); 
	        } 
		
	}
}