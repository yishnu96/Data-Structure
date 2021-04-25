/*
!           Extract Unique characters

Given a string S, you need to remove all the duplicates. That means, the output string should contain each 
character only once. The respective order of characters should remain same, as in the input string.

Input format:
The first and only line of input contains a string, that denotes the value of S.
Output format :
The first and only line of output contains the updated string, as described in the task.
Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde
*/

import java.util.*;

public class Solution {
    
    
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) 
    {
// 		First we are using the HashMap it has (key:value) pair
//      HashMap<key,value> name = new HashMap() 
        HashMap<Integer,Integer>map = new HashMap();
//         Now we will put all the elements in our Hashmap from arr
        
        for(int val:arr){
            if(map.containsKey(val)){
                int count = map.get(val);
                map.put(val,count+1);
            }else{
                map.put(val,1);
            }
        }
        
//      Now we need an ArrayList
        ArrayList<Integer> output = new ArrayList();
        
        for(int i=0;i<arr.length;i++)
        {
            ArrayList<Integer> temp = new ArrayList();
            
                    int val = arr[i];
                    while(map.containsKey(val))
                    {
                        temp.add(val);
                        val+=1;
                    }
            if(output.size() < temp.size()){
                output = new ArrayList();
                output.addAll(temp);
            }
                
        }
        
        return output;
        
	}
}