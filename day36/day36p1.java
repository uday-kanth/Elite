package day36;

/*There is an integer array of N heights. You have to pick certain number of heights
from the array everytime. Find the maximum  sum of all the heights picked 
everytime that meet the following conditions:
    - The length of the subarray is L, and
    - All the heights of the subarray picked are distinct.

Return the maximum subarray sum of all the height subarrays that meet the 
conditions. If no heights subarray meets the conditions, return 0.

- A subarray is a contiguous non-empty sequence of elements within an array.

Input Format:
-------------
Line-1: Two space separated integers, N and L
Line-2: N space separated integers, height[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 3
7 7 7 1 5 4 2

Sample Output-1:
----------------
13

Explanation: 
------------
The subarrays of length 3 of height array are:
    - [7,7,7] this subarray does not meet the requirement because the 7 is repeated.
    - [7,7,1] this subarray does not meet the requirement because the 7 is repeated.
    - [7,1,5] this subarray meets the requirements and its sum is 13.
    - [1,5,4] this subarray meets the requirements and its sum is 10.
    - [5,4,2] this subarray meets the requirements and its sum is 11. 

Return 13 because it is the maximum subarray sum of all the subarrays 
that meet the conditions


Sample Input-2:
---------------
3 3
7 7 7

Sample Output-2:
----------------
0

Explanation:
------------
The subarrays of length 3 of height array are:
- [7,7,7] which does not meet the requirements because the element 7 is repeated.

Return 0 because no subarrays meet the conditions.
 */


 import java.util.*;

class day36p1{
    public static void main (String[] args) {
        Scanner sc=new Scanner (System.in);
        
        int n=sc.nextInt();
        int w=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map <Integer ,Integer> m=new HashMap<>();
        int maxsum=0;
        
        int currsum=0;
        
        for(int i=0;i<w;i++){
            int t=m.getOrDefault(arr[i],0);
            m.put(arr[i],t+1);
            
            currsum+=arr[i];
            maxsum=Integer.max(maxsum,currsum);
            if(t!=0){
                maxsum=0;
            }
            
        }
        
        
        for(int i=1;i<n-w+1;i++){
            
            currsum-=arr[i-1];
            m.put(arr[i-1],m.getOrDefault(arr[i-1],0)-1);
            
            currsum+=arr[i+w-1];
            m.put(arr[i+w-1],m.getOrDefault(arr[i+w-1],0)+1);
            if(m.getOrDefault(arr[i-1],0)==0){m.remove(arr[i-1]);}
            if(m.size()<w){
                continue;
            }
            else{
                maxsum=Integer.max(maxsum,currsum);
            }
            
            
            
            
        }
        
        System.out.println(maxsum);
        sc.close();
        
        
        
        
    }
}