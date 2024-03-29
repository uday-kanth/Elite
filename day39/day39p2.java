/*Given a matrix of 0's and 1's of dimension rows X cols.

We could traverse from one element(row, col) to any other element(row + 1, col) or (row, col + 1).

Print 'true' if there is any path from first element(0,0) of the matrix to the last element(rows - 1, cols - 1) 
of the matrix that visits the same number of 1's and 0's.
Print 'false' otherwise.


Input Format
-------------
Line-1: Read two integers rows and cols(space separated).
Line-2: Read the matrix of dimension rows X cols.

Output Format
--------------
If the required path exist print 'true' otherwise 'false'.


Sample input-1
3 4
0 1 1 0
0 0 0 0
0 0 1 0
Sample output-1
true

Explanation: In the given matrix there is a path that is having three 0's and three 1's.

Sample input-2
4 3
0 0 1
1 0 0
0 0 0
0 0 1
Sample output-2
false

Explanation: There is NO path that is having same number of 0's and 1's.


 */

 import java.util.*;
class day39p2{
    
    static boolean DFS(int grid[][],int r,int c,int i,int j,int zcount,int ocount){
        if(i>=r || j>=c){
            return false;
        }
        if(grid[i][j]==0){
            zcount++;
        }else{
            ocount++;
        }
        
        
        if(i==r-1 && j==c-1){
        if(zcount==ocount){
            return true;
        }
        else{
           return false;
        }
        }
        
        return DFS(grid,r,c,i+1,j,zcount,ocount) || DFS(grid,r,c,i,j+1,zcount,ocount);
        
        
        
        
    }
    
    
    
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int grid[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        
        System.out.println(DFS(grid,r,c,0,0,0,0));
        sc.close();
        
        
        
    }
}