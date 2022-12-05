/*Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color.Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the unique shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the unique shapes by the lights.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by Blue Lights.


Sample Input-1:
---------------
4 5
1 1 0 1 1
1 1 0 0 1
0 0 0 0 0
1 1 0 0 0

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  		  1 1
1      and      1






 */


import java.util.*;

class d6p1{
    
    
    static String BFS(int mat[][] ,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        StringBuilder sb=new StringBuilder();
        sb.append('o');
        char cdir[]=new char[]{'r','d','l','u'};
        int dir[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int point[]=q.poll();
            mat[point[0]][point[1]]=0;
            
            for(int k=0;k<4;k++){
                int x=point[0]+dir[k][0];
                int y=point[1]+dir[k][1];
                if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && mat[x][y]==1){
                    q.offer(new int[]{x,y});
                    sb.append(cdir[k]);
                    mat[x][y]=0;
                }
    
            }
            sb.append('b');
            
            
            
            
        }
        
        return sb.toString();
        
        
        
        
    }
    
    

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int r=sc.nextInt();
        int c=sc.nextInt();
        
        int [][] mat=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j]=sc.nextInt();
                
            }
        }
        
        Set<String> res=new HashSet<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]!=0){
                    res.add(BFS(mat,i,j));
                    System.out.println(res);
                }
            }
        }
        
        System.out.println(res.size());
     
        
        
        
        
        
        
    }
}