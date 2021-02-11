/* 

!                           Byte Landian

Byteland has a very strange monetary system.
Each Bytelandian gold coin has an integer number written on it. 
A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. 
But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. 
The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?

* Input format :
    The first and the only line of input contains a the integer value of 'n'. It is the number written on your coin.
* Output format :
    Print the the maximum amount of American dollars you can make.


*Sample Input 1 :       12
*Sample Output 1 :   13
*Explanation of Sample Output 1 :
    You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
*/


    static HashMap<Long, Long> dp = new HashMap<>();
	public static long bytelandian(long n){
        
        if  (n < 12) 
            return n;
        
        if (dp.getOrDefault(n, 0l) != 0l) 
            return dp.get(n);
        
        long ans = bytelandian(n/2) + bytelandian(n/3) + bytelandian(n/4);
        
        dp.put(n, ans);
        
        return ans;
	}