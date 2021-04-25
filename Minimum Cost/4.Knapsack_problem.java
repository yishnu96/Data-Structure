/*

!                           Knapsack - Problem

A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, 
and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the 
thief can steal?

*Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.
The second line of input contains the N number of weights separated by a single space.
The third line of input contains the N number of values separated by a single space.
The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.

*Output Format :
Print the maximum value of V that the thief can steal.

*Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100
Time Limit: 1 sec

?Sample Input 1 :
4
1 2 4 5
5 4 8 6
5

?Sample Output 1 :
13
*/


public static int knapsack(int[] weight,int value[],int maxWeight, int n){
        
      	int[][] dp = new int[n+1][maxWeight+1];
		
		for(int i=n-1;i>=0;i--)
		{
			for(int w=0;w <= maxWeight; w++)
			{
				int ans;
				if(weight[i] <= w)
				{
					int ans1 = value[i] + dp[i+1][w - weight[i]];
					int ans2 = dp[i+1][w];
					ans = Math.max(ans1, ans2);
				}
				else
					ans = dp[i+1][w];
				
				dp[i][w] = ans;
			}
		}
		
		return dp[0][maxWeight];
        
}