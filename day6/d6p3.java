/*In AMB mall, to attract kids and to increase their economy they setup 
a separate Fun Zone. They opened a stall by name Soda Bears. We have an 
LED display panel with different colours of Soda bears.

You will be given a 2D integer panel representing the grid of a 
Soda bears, we have different color-codes as positive integer in 
panel [p][q] of each coloured soda bears. If a cell in 
panel[p][q]=0 representing at position (p,q) is empty. 

The given panel represents the state of game according to participants move. 
Now it’s your aim to make panel to a stable state by merging Soda Bears 
with certain conditions:

1. If three or more soda bears of the same colour are adjacent 
vertically or horizontally,"merge" them all at the same time - 
these locations become empty.

2. After merging all Soda Bears simultaneously, if an empty space on
the panel has soda bears on top of itself, then these bears will drop
until they hit another bear or bottom at the same time. 
(No new soda bear will drop outside the top boundary.)

3. After the above steps, there may exist more bears that can be merged. 
If so, you need to repeat the above steps.

4. If there does not exist more bears for merge (ie. the panel is stable), 
then return the current panel.

Repeat the procedure for stable panel, then return the current panel state.

Input Format:
-------------
Line-1: Two space separated integers, M and N size of panel
Next M lines: N space separated integers, color codes of soda bears.

Output Format:
--------------
Print the stable format of panel.


Sample Input-1:
--------------
8 4
11 5 13 5
12 13 5 13
1 2 3 4
11 2 3 4
2 2 2 5
13 13 3 4
14 13 13 14
12 12 11 13

Sample Output-1:
----------------
0 0 0 5
11 0 0 13
12 0 0 4
1 0 0 4
11 0 13 5
13 0 5 4
14 5 13 14
12 12 11 13


Sample Input-2:
--------------
7 8
1 1 1 1 1 1 1 1
2 1 1 1 1 1 1 2
3 2 1 1 1 1 2 3
4 3 2 1 1 2 3 4
3 2 1 1 1 1 2 3
2 1 1 1 1 1 1 2
1 1 1 1 1 1 1 1

Sample Output-2:
----------------
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
2 0 0 0 0 0 0 2
3 0 0 0 0 0 0 3
4 2 0 0 0 0 2 4
3 3 0 0 0 0 3 3 */

import java.util.*;
class d6p3{
    public static void stable(int board[][]){
        boolean stable=false;
        while(!stable){
            stable=true;
            List<int[]> remove=new ArrayList<>();
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j]!=0){
                        List<int[]> cur=search(board, i, j);
                        if(!cur.isEmpty()){
                            remove.addAll(cur);
                            stable=false;
                        }
                    }
                }
            }
            for(int c[]: remove){
                board[c[0]][c[1]]=0;
            }
            if(!stable){
                drop(board);
            }
        }
        return;
    }
    public static List<int[]> search(int board[][], int r, int c){
        List<int[]> cur=new ArrayList<>();
        int val=board[r][c];
        if(val==0){
            return cur;
        }
        int dir[][]={{1,0}, {0,1}};
        for(int d[]: dir){
            List<int[]> direct=new ArrayList<>();
            int x=r+d[0], y=c+d[1];
            while(x>=0 && x<board.length && y>=0 && y<board[x].length && board[x][y]==val){
                direct.add(new int[]{x,y});
                x+=d[0];
                y+=d[1];
            }
            if(direct.size()>=2){
                cur.addAll(direct);
            }
        }
        if(!cur.isEmpty()){
            cur.add(new int[]{r, c});
        }
        return cur;
    }
    public static void drop(int board[][]){
        int r=board.length, c=board[0].length;
        for(int i=0; i<c; i++){
            int i1=r-1, i2=r-1;
            while(i1>=0){
                if(board[i1][i]==0){
                    i1--;
                }
                else{
                    board[i2--][i]=board[i1--][i];
                }
            }
            while(i2>=0){
                board[i2--][i]=0;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(), n=sc.nextInt();
        int board[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j]=sc.nextInt();
            }
        }
        stable(board);
        System.out.println(Arrays.deepToString(board));
        sc.close();
    }
}

