/*In an International school 9th standard students have been assigned a task.

Given a list of numbers nums[] and three values p, q and r.
They have to solve the equation function(x)=p(x^2)+q(x)+r, 
for each number(x) in the given list nums[],
and print the resultant values in the sorted order.

Input Format:
-------------
Line-1: An integer N, size of list nums[].
Next N lines: space separated integers, nums[]
Last Line: 3 space separated integers, P, Q and R.

Output Format:
--------------
Print a list of numbers[].


Sample Input-1:
---------------
4
-3 -2 2 4
2 3 5

Sample Output-1:
----------------
7 14 19 49



Sample Input-2:
---------------
4
-3 -2 1 2
-2 3 5

Sample Output-2:
----------------
-22 -9 3 6
 */


import java.util.*;
class d6p2{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=sc.nextInt();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int t1=p*nums[i]*nums[i];
            int t2=q*nums[i];
            ans[i]=t1+t2+r;
        }
        int s=0;
        int e=n-1;
        int res[]=new int[n];
        
        //System.out.println(Arrays.toString(ans));
        
        if(p>0){
            for(int i=n-1;i>=0;i--){
                int x=ans[s]>ans[e]? 1:0;
                //System.out.println(ans[s]+" "+ans[e]);
                
                if(x==1){
                    res[i]=ans[s];
                    s++;
                }
                else{
                    res[i]=ans[e];
                    e--;
                }
                
                
            }
        }
        if(p<0){
            for(int i=0;i<n;i++){
                int x=ans[s]<ans[e]?1:0;
                if(x==1){
                    res[i]=ans[s];
                    s++;
                }
                else{
                    res[i]=ans[e];
                    e--;
                }
            }
        }
            
            
        
            
            
            
        
        
        
        
        System.out.println(Arrays.toString(res));
        sc.close();
        
        
        
            
        
        
        
        
        
        
    }
}