/*There is a competetion conducted at a school where students are given string 
of English letters. String consits of lower case letters.

A student can alter the string and create a new string so that, when reversed, 
the altered and and its reveresed strings should be equal, designating a winner.

There is a constraint that each string can be altered atmost twice. 
In one operation, you can change any character of string to any other character.

The student has to return "true" if he is winner, otherwise return "false"

Input Format:
-------------
A string, S

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
xyzwyx

Sample Output-1:
----------------
true

Explanation:
------------
One way to alter the string such that it matches the given criteria,
using 1 operation is:

- Change s[2] to 'w'. Now, s = "xywwyx".
One operation could be performed to make our required string so return true.


Sample Input-2:
---------------
pp

Sample Output-2:
----------------
true

Explanation:
------------
One way to alter the string such that it matches the given criteria,
using 2 operations is:
- Change s[0] to 'q'. Now, s = "qp".
- Change s[1] to 'q'. Now, s = "qq".
Two operations could be performed to make our required string so return true.


Sample Input-3:
---------------
mnopqr

Sample Output-3:
----------------
false

Explanation:
------------
It is not possible to make string that matches the given criteria using 
one or two operations. So, return false.
 */


import java.util.*;

class d7p3{
    
    
    
    static boolean checkpalin(char [] arr){
        
        for(int i=0;i<arr.length/2;i++){
            if(arr[i]!=arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }
    
    
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        String s =sc.nextLine();
        char [] arr=s.toCharArray();
        
        if(checkpalin(arr)){
            System.out.println(true);
        }
        else{
            int l=arr.length;
            int c=0;
            int flag=0;
            for(int i=0;i<l/2;i++){
                
                if(arr[i]!=arr[l-1-i]){
                    arr[i]=arr[l-1-i];
                    c++;
                    if(c>2){
                        flag=1;
                        break;
                    }
                }
            }
            
            if(flag==0 && checkpalin(arr)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            sc.close();
            
            
            
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
    }
    
    
}