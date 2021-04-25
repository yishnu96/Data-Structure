/*
!           Minimum Number of Chocolates

Miss. Noor Rashid is a teacher. She wants to give some chocolates to the students in her class. 
All the students sit in a line, and each of them has a score according to performance. 
Noor wants to give at least one chocolate to each student. She distributes chocolates to them such that 
If two students sit next to each other, then the one with the higher score must get more chocolates. 
Miss. Noor wants to save money, so she wants to minimize the total number of chocolates.

*Note :
When two students have an equal score, they are allowed to have a different number of chocolates. 
*Input Format:
The first line of the input contains an integer value of N. It denotes the total number of students in 
Noor's class.
The second line of the input contains N integer values denoting the score of each of the students. 
A single space will separate them.
*Output Format:
Print the minimum number of chocolates Noor must give.
*Constraints
1 <= N <= 10^5
1 <= score <= 10^5
Time Limit: 1 sec

?Sample Input 1 :
4
1 4 4 6
?Sample Output 1 :
6
?Explanation:
One of the ways in which the chocolates can be distributed, such Noor has to give minimum number of chocolates,
 are: The first student can be given one chocolate, second student can be given two chocolates, 
 third student can be one chocolate and fourth can be given two chocolates.  

?Sample Input 2 :
3
8 7 5
?Sample Output 2 :
6

*/


	public static int getMin(int arr[], int n){

        int[] ans1 = new int[n];
		int[] ans2 = new int[n];
		int sum = 0 ;
		ans1[0] = 1;
		ans2[n-1] = 1;
		int i , j;
		for ( i = 1,j = n-2; i < n; i++ , j--) {
			
			if(arr[i] > arr[i-1])
				ans1[i] = 1 + ans1[i-1];
			
			else if(arr[i] <= arr[i-1])
				ans1[i] = 1;
			
			if(arr[j] > arr[j+1])
				ans2[j] = 1 + ans2[j+1];
			
			else if(arr[j] <= arr[j+1])
				ans2[j] = 1;
			
		}
					
		for(int k = 0; k<n ;k++)
			sum = sum + Math.max(ans1[k], ans2[k]);
		
		return sum;
  }