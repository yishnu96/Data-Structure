/*

!           Subset Sum

You are given a set of N integers. You have to return true if there exists a subset 
that sum up to K, otherwise return false.

*Input Format
The first line of the test case contains an integer 'N' representing the total elements in the set.
The second line of the input contains N integers separated by a single space.    
The third line of the input contains a single integer, denoting the value of K.
*Output Format
Output Yes if there exists a subset whose sum is k, else output No.
*Constraints :
1 <= N <= 10^6
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3
Time Limit: 1 sec

?Sample Input 1 :
4
4 3 5 2
13
?Sample Output 1 :
No
?Sample Input 2 :
5
4 2 5 6 7
14
?Sample Output 2 :
Yes

*/

    static boolean isSubsetSum(int arr[], int sum) 
    { 
		int n = arr.length;
		boolean dp[][] =  new boolean[sum+1][n+1]; 

		for (int i = 0; i <= n; i++) 
			dp[0][i] = true; 

		for (int i = 1; i <= sum; i++) 
			dp[i][0] = false; 

		for (int i = 1; i <= sum; i++) 
		{ 
			for (int j = 1; j <= n; j++) 
			{ 
				dp[i][j] = dp[i][j-1]; 
				if (i >= arr[j-1]) 
					dp[i][j] = dp[i][j] ||  
					dp[i - arr[j-1]][j-1]; 
			} 
		} 
		return dp[sum][n]; 
	} 

	public static void main (String args[]) 
	{ 
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		
		int sum =s.nextInt(); 
		if (isSubsetSum(arr, sum) == true) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 