/*Mansood Ali participated in a treasure-hunt conatins N boxes in it.
Each box is numbered from 0,1,2,3,...,N-1. 
All the boxes are intially locked with the passcodes, except Box-0.
The passcode is written in a envolope and marked with its concern box number.

Each box in the treasure hunt contains a list of envelopes, which has 
passcodes to open the other boxes. He can open the boxes in any order, 
but he has to start from box-0 intially.

The rule to win the treasure-hunt is to open all the boxes.
Your task is to find out, whether Mansood Ali win the treasure hunt or not.
If he win, print "Win", Otherwise, print "Lost"


Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win


Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost

*/

// import java.util.*;

// class Test{
    
//     static int find(int a,int[] parent){
//         if(parent[a]==a){
//             return a;
//         }
//         parent[a]=find(parent[a],parent);
//         return parent[a];
//     }
    
//     static void union(int x,int y,int[] parent){
//         int px=find(x,parent);
//         int py=find(y,parent);
        
//         if(px!=py ){
//             parent[py]=px;
//         }
        
        
//     }
    
    
    
    
    
    
    
    
    
//     public static void main (String[] args) {
//         Scanner sc=new Scanner(System.in);
        
//         int n=sc.nextInt();
        
//         Map<Integer,List<Integer>>m=new HashMap<>();
//         int parent[]=new int[n];
        
//         for(int i=0;i<n;i++){
//             parent[i]=i;
//         }
        
//         sc.nextLine();
        
//         for(int i=0;i<n;i++){
//             //List<Integer> temp=new ArrayList<>();
//             String [] s=sc.nextLine().split(" ");
//             //System.out.println(Arrays.toString(s));
//             for(int j=0;j<s.length;j++){
//                 union(i,Integer.parseInt(s[j]),parent);
//             }
//         }
        
//         int count=0;
//         for(int i=0;i<n;i++){
//             if(find(i,parent)==i){
//                 count++;
//             }
            
//         }
        
//         System.out.println(Arrays.toString(parent));
        
//         if(count==1){
//             System.out.println("Win");
//         }
//         else{
//             System.out.println("Lost");
//         }
        
        
        
        
        
        
        
//     }
    
    
    
// }



import java.util.*;
class d4p1
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,List<Integer>> m1=new HashMap<>();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String s[]=sc.nextLine().split(" ");
            List<Integer> l1=new ArrayList<>();
            for(String a:s)l1.add(Integer.parseInt(a));
            m1.put(i,l1);
        }
        Queue<List<Integer>> q=new LinkedList<>();
        q.offer(m1.get(0));
        Set<Integer> visited=new HashSet<>();
        visited.add(0);
        boolean b=false;
        while(!q.isEmpty())
        {
            List<Integer> l1=q.poll();
            int flag=0;
            for(int i:l1)
            {
                if(visited.size()==n)
                {
                    b=true;
                    flag=1;
                    break;
                }
                if(!visited.contains(i))
                {
                    visited.add(i);
                    q.offer(m1.get(i));
                }
            }
            if(flag==1)break;
        }
        if(b)System.out.println("Win");
        else System.out.println("Lost");
        sc.close();
    }
}