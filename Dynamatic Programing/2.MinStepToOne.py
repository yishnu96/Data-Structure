"""
                Min Steps To One

Given a positive integer 'n', 
find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:

    1.) Subtract 1 from it. (n = n - ­1) ,
    2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
    3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).


Input format :
    The first and the only line of input contains an integer value, 'n'.
Output format :
    Print the minimum number of steps.
"""

from sys import stdin, setrecursionlimit 
from sys import maxsize as MAX_VALUE 
setrecursionlimit(10 ** 6) 

import time 
def countMinStepsToOne(n) : 
    if n == 1 : 
        return 0 
        
    subtractOne = MAX_VALUE 
    divideByTwo = MAX_VALUE 
    divideByThree = MAX_VALUE 
    
    subtractOne = countMinStepsToOne(n - 1) 
    
    if n % 2 == 0 : 
        divideByTwo = countMinStepsToOne(n // 2) 
        
    if n % 3 == 0 : 
        divideByThree = countMinStepsToOne(n // 3) 
        
    return 1 + min(subtractOne, divideByTwo, divideByThree) 
    
#main 
n = int(stdin.readline().rstrip()) 
print(countMinStepsToOne(n))