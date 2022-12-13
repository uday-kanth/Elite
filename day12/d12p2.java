/*A graduate at University of California (UoC) has to follow certain rules.

UoC offering K subjects, the subjects are indexed from 0 to K-1.
To complete the subjets, you have to follow the conditions, like 
condition[i]= [Xi, Yi], which specifies you must take the subject Xi 
before the subject Yi.

Conditions can be indirect, i.e., take course-A to take course-B, and take 
course-B to take course-C, then you have to take course-A to take course-C.

You are given total number of subjects, a list of C condition pairs and 
a list of Q queries where queries[i] = [Ai, Bi]. For the ith query, 
you should answer whether you have to take course Ai to take course Bi or not 
and return the answers as a boolean list answers[].

NOTE:
It is guaranteed that the course conditional graph continas no cycle.

Input Format:
-------------
Line-1: 3 space separated integers, N, C and Q
Next C lines: Two space separated integers, conditions[]
Next Q lines: Two space separated integers, conditions[]

Output Format:
--------------
Print Q boolean values as result.


Sample Input-1:
---------------
3 3 2
1 2
1 0
2 0
1 0
1 2

Sample Output-1:
----------------
true true


Sample Input-2:
---------------
5 4 3
0 1
0 2
1 4
1 3
0 2
1 3
1 2

Sample Output-2:
----------------
true false true
 */

 import java.util.*;


class d12p2{
    // static int find(int a,int[] parent){
    //     if(a==parent[a]){
    //         return a;
    //     }
        
    //     return find(parent[a],parent);
        
    // }
    
    
    
    // static void union(int a,int b,int[] parent){
    //     int pa=find(a,parent);
    //     int pb=find(b,parent);
        
    //     if(pa!=pb){
    //         parent[b]=a;
    //     }
        
        
        
    // }
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int parent[]=new int[n];
        Map<Integer,List<Integer>> m=new HashMap<>();
        for(int i=0;i<n;i++){
            parent[i]=i;
            m.put(i,new ArrayList<Integer>());
        }
        int c=sc.nextInt();
        int q=sc.nextInt();
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<c;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            l.add(new int[]{a,b});
        }
        
        Collections.sort(l,(a,b)->{return a[0]-b[0];});
        //System.out.println(l);
        
        for(int i=0;i<c;i++){
            m.get(l.get(i)[1]).add(l.get(i)[0]);
            m.get(l.get(i)[1]).addAll(m.get(l.get(i)[0]));
        }
        
        
        List<Boolean> ans=new ArrayList<>();
    
        for(int i=0;i<q;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(m.get(b).contains(a)){
                ans.add(true);
            }
            else{
                
                ans.add(false);
                
                
            }
        
        }
        System.out.println(ans);
        sc.close();
        
        
        
        
    }
}