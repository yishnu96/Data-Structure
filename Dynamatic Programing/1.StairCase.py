
""" Stair Case

A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. 
Implement a method to count and return all possible ways in which the child can run-up to the stairs."""

from sys import stdin 
def staircase(n) : 
    ways = [0] * (n + 1) #this is our DP array/list of size (n + 1) 
    #Base Cases 
    if n == 0 : 
        return 1 

    if n == 1 or n == 2 : 
        return n 
        
    ways[0] = 1 
    ways[1] = 1 
    ways[2] = 2 
    
    for i in range(3, (n + 1)) : 
        ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3] 
        
    return ways[n] 
    
#main 
n = int(stdin.readline().rstrip()) 
print(staircase(n))