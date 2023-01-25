package day36;

/*
     Given a matrix of dimension rows X cols with the elements 0's and 1's,

Your task is to convert all matrix elements to 0's by following 
the condition given below.

The condition is, in every operation, you could select any 
row or any column of the given matrix and toggle each element 
in that row or column.

Note: Toggle means changing all 0's to 1's and all 1's to 0's.

Print true if you could change all matirix elements to 0's 
by following given condition else print false.


Input Format
-------------
Line-1: Read two integers rows and cols(space separated).
Line-2: Read the matrix of dimension rows X cols.

Output Format
--------------
Print a boolean result.



Sample input-1:
---------------
5 5
0 0 1 0 0
0 0 1 0 0
1 1 0 1 1
0 0 1 0 0
0 0 1 0 0

Sample output-1:
----------------
true

Explanation:
------------
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
0 0 1 0 0   row-3  0 0 1 0 0   cols-3  0 0 0 0 0
1 1 0 1 1   --->   0 0 1 0 0   --->    0 0 0 0 0
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
0 0 1 0 0          0 0 1 0 0           0 0 0 0 0 


Sample input-2
--------------
2 2
1 1
0 1

Sample output-2
---------------
false

 */


 import java.util.*;

class day36p2{
   static void matrix(int arr[][],int n,int m){
        int sel[]=new int[n];
        String ch1="";
        String ch2="";
        boolean b=true;
        for(int i=0;i<n;i++)
        {
            ch1+="1";
            ch2+="0";
            sel[i]=arr[0][i];
        }
        for(int i=1;i<m;i++)
        {
            String s="";
            for(int j=0;j<n;j++)
            {
                s+=arr[i][j]^sel[j];
            }
            if(s.equals(ch1) || s.equals(ch2)){}
            else
            {
                b=false;
                break;
            }
        }
        System.out.println(b);
    
        
        
        
        
    }
    public static void main (String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int r=sc.nextInt();
        // int c=sc.nextInt();
        // sc.nextLine();
        // String check="";
        // for(int i=0;i<c;i++){
        //     check+='1';
        // }
        // int checker=Integer.parseInt(check);
        // //System.out.println(checker);
        
        
        
        // String s = String.join("",sc.nextLine().split(" "));
        // int ref=Integer.parseInt(s);
        // int flag=0;
        // for(int i=1;i<r;i++){
            
        //     String temp=String.join("",sc.nextLine().split(" "));
        //     int x=Integer.parseInt(temp);
            
        //     int y=x^ref;
        //     //System.out.println(y);
        //     if(y!=0 && y!=checker){
        //         flag=1;
        //     }
            
            
        // }
        
        // if(flag==1){
        //     System.out.print(false);
        // }
        // else{
        //     System.out.print(true);
        // }
        
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)arr[i][j]=sc.nextInt();
        }
        matrix(arr,n,m);
        sc.close();
        
    }
}