/*A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true*/


import java.util.*;

class d4p2{
    
    static int find(int a,int parent[]){
        if(a==parent[a]){
            return a;
        }
        parent[a]=find(parent[a],parent);
        return parent[a];
    }
    
    static void union(int x,int y,int []parent){
        int px=find(x,parent);
        int py=find(y,parent);
        
        if(px!=py){
            parent[py]=px;
        }
        
    }
    
    
    
    
    
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String s[]=sc.nextLine().split(" ");
        
        int parent[]=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        
        
        List<char[]>l=new ArrayList<>();
        
        for(int i=0;i<s.length;i++){
            char [] arr=s[i].toCharArray();
            
            if(arr[1]=='!'){
                l.add(new char[]{arr[0],arr[3]});
            }
            else{
                union(arr[0]-'a',arr[3]-'a',parent);
        System.out.println(Arrays.toString(parent));
            }
        }
        
        int flag=0;
        for(int i=0;i<l.size();i++){
            char [] arr=l.get(i);
            if(find(arr[0]-'a',parent)==find(arr[1]-'a',parent)){
                flag=1;
                break;
            }
        }
        
        
        
        if(flag==0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        sc.close();
        
        
        
        
    }
}
