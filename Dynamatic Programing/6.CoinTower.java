/* 
!                   Coin Tower
Whis and Beerus are playing a new game today. 
They form a tower of N coins and make a move in alternate turns. 
Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. 
The person to make the last move wins the game. Can you find out who wins the game?
 
 *Input format :
        The first and the only line of input contains three integer values separated by a single space. They denote the value of N, X and Y, respectively.
*Output format :
        Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).

*Sample Input 1 :        4 2 3
*Sample Output 1 :       Whis
*/

	public  String solve(int n,int x,int y){
		
		int[] dp = new int[n+1];
        dp[1] = 1;
        dp[x] = 1;
        dp[y] = 1;
        
		
		for (int i = 1; i < dp.length; i++) {
            //u have to do these when dp[i] ==0 , or when dp[i] !=1, in case of x , y
            if(dp[i] ==0){
			int optn1 = dp[i-1]^1;
			int optn2 = 0;
			if(i-x >= 1)
				optn2 = dp[i-x] ^ 1;
			
			int optn3 = 0;
			if(i-y >= 1)
				optn3 = dp[i-y] ^ 1;
            
			// System.out.println(optn1+" "+optn2+ " "+optn3);
			dp[i] = Math.max(optn1 , Math.max( optn2 ,optn3));
            }
			
		}
		
		String ans = "";
		if(dp[n] != 0)
			ans = "Beerus";
		else
			ans = "Whis";
		
		return ans;
		
	}