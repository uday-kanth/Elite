package day9;
/*In an exam hall, seating arrangement is done in a row, When an invigilator 
enters into exam hall he wants to exchange(swap) some students places in pairs.

Note: student names will be alphabets(a,b,c...z) may be repeated,
and seat number starts from zero(0 to N-1) where N is the number of students.

Invigilator may swap the students at any pair of seats(indices) in 
the given pairs any number of times.

Given the seating-arrangement s, and list of pairs of seats(indices) in 
seating-arrangement pairs where pairs[i]=[x,y] denotes 2 indices 
(index starts from zero(0)) of the seating-arrangement s.

Your task is to print the lexicographically smallest seating-arrangement S
that has been changed after using the swaps.


Input Format:
-------------
Line-1: Read a String seating-arrangement s.
Line-2: Read the number of pairs of seat numbers to swap R.
Next R lines: Two space separated integers, pair of seat numbers.

Output Format:
--------------
Print the lexicographically smallest seating-arrangement s after using the swaps.

Sample Input-1:
---------------
feabdc
2       
0 4
1 3

Sample Output-1:
----------------
dbaefc

Explanation:
------------
Swap s[0] and s[4], s = "deabfc"
Swap s[1] and s[3], s = "dbaefc"

Sample Input-2:
---------------
edb
2
0 1
1 2

Sample Output-2:
----------------
bde

Explanation:
------------
Swap s[0] and s[1], s = "deb"
Swap s[1] and s[2], s = "dbe"
Swap s[0] and s[1], s = "bde"

 */
import java.util.*;
class Solution{
    static void union(int a,int b,int[] par,String s){
        a=find(a,par);
        b=find(b,par);
        if(a!=b){
            if(s.charAt(a)>s.charAt(b)){
                par[a]=b;
            }
            else{
                par[b]=a;
            }
        }
    }
    static int find(int k,int[] par){
        if(par[k]==k){
            return k;
        }
        else{
            return par[k]=find(par[k],par);
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        int[] par=new int[s.length()];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            par[i]=i;
        }
        
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        for(int[] a:arr){
            union(a[0],a[1],par,s);
        }
        for(int i = 0; i<s.length()-1; i++){
            int x = find(par[i],par);
            if(!set.contains(x)){
                List<Integer> l = new ArrayList<>();
                List<Character> lc = new ArrayList<>();
                l.add(i);
                lc.add(s.charAt(i));
                for(int j = i+1; j<s.length(); j++){
                    if(x==find(par[j],par)){
                        l.add(j);
                        lc.add(s.charAt(j));
                    }
                }
                Collections.sort(lc);
                for(int z = 0; z<l.size() ; z++){
                    s=s.substring(0,l.get(z))+lc.get(z)+s.substring(l.get(z)+1);
                }
            }
        }
        System.out.print(s);
        sc.close();
    }
}