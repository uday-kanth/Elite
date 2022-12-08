package day9;
/*In a school in Telangana students like to play with strings by splitting them.

If they are given two strings s1 and s2 of the same length.
They split both strings at the same choosen index , splitting s1 into 
two strings: prefix and suffix where s1 = prefix + suffix, and splitting s2 
into two strings: prefix1 and suffix1 where s2 = prefix1 + suffix1.

Check if prefix + suffix1 or prefix1 + suffix forms a palindrome.

For example, if s = "xyz", then "" + "xyz", "x" + "yz", "xy" + "z" , 
and "xyz" + "" are valid splits.

Return true if it is possible to form a palindrome string, 
otherwise return false.

Notice that x + y denotes the concatenation of strings x and y.


Example 1:
----------
Input: s1 = "a", s2 = "b"
Output: true
Explaination: If either s1 or s2 are palindromes the answer is true 
since you can split in the following way:
s1prefix = "", s1suffix = "a"
s2prefix = "", s2suffix = "b"
Then, s1prefix + s2suffix = "" + "b" = "b", which is a palindrome.

Example 2:
-----------
Input: a = "zdfgh", b = "zgecd"
Output: false

Example 3:
----------
Input: s1 = "vmbdge", s2 = "kjabmv"
Output: true
Explaination: Split them at index 3:
prefix = "vmb", suffix = "dge"
prefix1 = "kja", suffix1 = "bmv"
Then, prefix + suffix1 = "vmb" + "bmv" = "vmbbmv", which is a palindrom


Sample Input-1:
---------------
a b----> two strings

Sample Output-1:
----------------
true


Sample Input-2:
---------------
vmbdge kjabmv   ------->two strings

Sample Output-2:
----------------
true
 */

import java.util.*;
class d9p3{
    static boolean ispal(String a){
        StringBuilder sb=new StringBuilder(a);
        sb.reverse();
        return sb.toString().equals(a); 
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]input=sc.nextLine().split(" ");
        String a=input[0];
        String b=input[1];
        
        for(int i=0;i<a.length()+1;i++){
            if(ispal(a.substring(0,i)+b.substring(i)) || ispal(b.substring(0,i)+a.substring(i))){
                System.out.println(true);
                System.exit(0);
            }
        }
        System.out.println("false");
        sc.close();
    }
}