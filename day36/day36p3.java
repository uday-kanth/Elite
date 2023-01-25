package day36;

/*
 In a school Students are given four integers which defines minimumLength, 
maximumLength, oneGroup and zeroGroup related to strings

A binary string is good if it satisfies the following conditions:
    -- The length of the string is in the range [minimumLength, maximumLength].
    -- The size of each block of consecutive 1's is a multiple of oneGroup.
       For example in a binary string 00110111100 sizes of each block of 
       consecutive ones are [2,4].
    -- The size of each block of consecutive 0's is a multiple of zeroGroup.
       For example, in a binary string 00110111100 sizes of each block of 
       consecutive zeros are [2,1,2].

Return the number of good binary strings. Since the answer may be too large, 
return it modulo 10^9 + 7.
Note that 0 is considered a multiple of all the numbers.

Input Format
------------
read min, max, onegroup, zerogroup four integers

output Format
------------
An integer which is no of good strings


Sample Input-1:
---------------
2 3 1 2

Sample Output-1:
----------------
5

Explanation:
------------
There are 5 good binary strings in this example: "00", "11", "001", "100", and "111".
It can be proven that there are only 5 good strings satisfying all conditions.


Sample Input-2:
---------------
4 4 4 3

Sample Output-2:
----------------
1

Explanation:
------------
There is only 1 good binary string in this example: "1111".
It can be proven that there is only 1 good string satisfying all conditions.

 */


 import java.util.*;

 // class day36p3{
 //     static String x1="";
 //     static String x2="";
 //     static String y1="";
 //     static String y2="";
 //     static List<String> binary(int min,int max,int one ,int zero,int n){
         
 //         if(n==min){
             
             
             
 //             List <String> res=new ArrayList<>();
 //             StringBuilder sb1=new StringBuilder();
 //             StringBuilder sb2=new StringBuilder();
 //             if(os!=0){
             
 //             for(int i=0;i<os;i++){
 //                 sb1.append('1');
 //             }
 //             x1=sb1.toString();
 //             res.add(x1);
 //             }
 //             if(ts!=0){
             
 //             for(int i=0;i<ts;i++){
 //                 sb2.append('0');
 //             }
 //             x2=sb2.toString();
 //             res.add(x2);
 //             }
 //             return res;
 //         }
         
         
 //         List <String> temp=binary(min,max,one,zero,n-1);
 //         List <String> res =new ArrayList<>();
 //         for(int i=0;i<temp.size();i++){
 //             res.add(temp.get(i));
 //             if(n-temp.get(i).length()>=one){
 //                 res.add(temp.get(i)+y1);
 //                 res.add(y1+temp.get(i));
 //             }
             
 //             if(n-temp.get(i).length()>=zero){
 //                 res.add(temp.get(i)+y2);
 //                 res.add(y2+temp.get(i));
 //             }
             
             
             
 //         }
 //         return res;
         
         
         
         
         
         
 //     }
     
     
     
     
     
 //         static int os=0;
 //         static int ts=0;
 //     public static void main (String[] args) {
 //         Scanner sc=new Scanner(System.in);
         
 //         int min=sc.nextInt();
 //         int max=sc.nextInt();
 //         int one=sc.nextInt();
 //         int zero=sc.nextInt();
         
 //         int f1=0;
 //         int f2=0;
         
 //         for(int i=min;i<=max;i++){
 //             if(i%one==0 && f1==0){
 //                 os=i;f1=1;
 //             }
 //             if(i%zero==0 && f2==0){
 //                 ts=i;f2=1;
 //             }
 //         }
 //         StringBuilder sb1=new StringBuilder();
 //         for(int i=0;i<one;i++){
 //             sb1.append('1');
 //         }
 //         y1=sb1.toString();
         
 //         StringBuilder sb2=new StringBuilder();
 //         for(int i=0;i<zero;i++){
 //             sb2.append('0');
 //         }
 //         y2=sb2.toString();
         
         
         
 //         List <String> res=binary(min,max,one,zero,max);
 //         Set<String> fin=new HashSet<>();
 //         for(String x: res){
 //             fin.add(x);
 //         }
         
 //         System.out.println(fin);
         
         
 //     }
 // }import java.util.*;
 
 class day36p3{
     public static void main (String[] args) {
         Scanner sc= new Scanner(System.in);
         int mn= sc.nextInt();
         int mx= sc.nextInt();
         int o= sc.nextInt();
         int z= sc.nextInt();
         int[] dp= new int[mx+1];
         int sum=0;
         
         for(int i=1; i<=mx; i++){
             int one= Math.max(i-o,0);
             int zero= Math.max(i-z,0);
             if(i==o && i==z) dp[i]= (dp[i]+2)%1000000007;
             else if(i==z) dp[i]= (dp[i]+1+dp[one])%1000000007;
             else if(i==o) dp[i]= (dp[i]+1+dp[zero])%1000000007;
             
             else dp[i]+= (dp[one]+dp[zero])%1000000007;
             
             if(i>=mn){
                 sum= (sum+dp[i])%1000000007;
             }
             // sum= sum%(int)(Math.pow(10,9)+7);
         }
         // System.out.println((int)(Math.pow(10,9)+7));
         System.out.println(sum);
         sc.close();
     }
 }