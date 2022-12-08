package day9;
/*A game-zone is represented as an infinite 2D grid. At every integer coordinate 
(x,y) there is a bag, and the bag contains |x| + |y| number of chocolates in it.

You want grab N chocolates for your kid. You have to select some square area in 
the game-zone such a way that the selected area is an axis-aligned square plot 
that is centered at (0, 0).

Your task is to find the minimum perimeter of the square area such that 
at least it conains N chocolates are inside or on the perimeter of that area.

NOTE: 
The value of |x| is defined as: x if x >= 0 -x if x < 0

Constarint:
-----------
1 <= N <= 10^14

Input Format:
-------------
An integer N, number of chocolates.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5

Sample Output-1:
----------------
8

Explanation:
------------


Sample Input-2:
---------------
56

Sample Output-2:
----------------
16

Explanation:
------------


Sample Input-3:
---------------
62

Sample Output-3:
----------------
24

 */
import java.util.*;
class Solution{
    static long function(long n){
        long low=0,high=100000,mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            long k=4*mid*mid*mid+6*mid*mid+2*mid;
            if(k>n){
                high=mid-1;
            }
            else{
                low=mid+1;
                
            }
        }
        return low;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        System.out.println(8*function(n));
        sc.close();
    }
}