/*
!               Longest Common Subsequence - Problem

Given two strings, S and T with lengths M and N, find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.


*Input format :
    The first line of input contains the string S of length M.
    The second line of the input contains the String T of length N.
*Output format : Print the length of the 'Longest Common Subsequence'.
*Constraints :
    0 <= M <= 10 ^ 3
    0 <= N <= 10 ^ 3


?Sample Input 1 :
adebc
dcadb
?Sample Output 1 : 3
Explanation of the Sample Input 1 :
Both the strings contain a common subsequence 'adb', which is the longest common 
subsequence with length 3. 

?Sample Input 2 :
ab
defg
?Sample Output 2 : 0
Explanation of the Sample Input 2 :
The only subsequence that is common to both the given strings is an empty 
string("") of length 0.
*/

	public static int lcs(String str1, String str2){
        int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--)
			{
				int ans;
				if(str1.charAt(i) == str2.charAt(j))
					ans = 1 + dp[i+1][j+1];
				
				else {
					int ans1 = dp[i][j+1];
					int ans2 = dp[i+1][j];
					ans = Math.max(ans1, ans2);
				}
				dp[i][j] = ans;
			}
		}
		
		return dp[0][0];
    }