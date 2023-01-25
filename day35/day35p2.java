/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.



Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false

 */import java.util.*;

class day35p2{
    public static void main (String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        // int flag=0;
        // if(s.length()==2){
        //     int l=s.charAt(0)-'a';
        //     int r=s.charAt(1)-'a';
        //     if((l^r)==0){flag=1;}
            
        // }else{
        
        
        // for(int i=1;i<s.length()-1;i++){
            
        //     int m=s.charAt(i)-'a';
        //     int l=s.charAt(i-1)-'a';
        //     int r=s.charAt(i+1)-'a';
            
        //     if((m^r)==0){
        //         flag=1;
        //     }
        //     else if((l^r)==0){
        //         flag=1;
        //     }
        //     if(flag==1){
        //         break;
        //     }
            
        // }
        // }
        // if(flag==1){System.out.println(true);}
        // else{System.out.println(false);}
    // int sum=0;
    //     for(int i=0;i<s.length();i++){
    //         sum^=(s.charAt(i)-'a'+1);
    //     }
        
    //     if(s.length()%2==0 && sum==0){
    //         System.out.println(true);
    //     }
    //     else if(s.length()%2!=0 && sum>0 && sum<('z'-'a'+1)){
    //         System.out.println(true);
    //     }
    //     else{
    //         System.out.println(false);
    //     }
    
   
        boolean flag=true;
        String add="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int co=0;
            for(int j=0;j<s.length();j++){
                char d=s.charAt(j);
                int x=c^d;
                if(x==0){
                    co++;
                }
            }
            if(co%2!=0){
                if(flag==false && add.indexOf(c)==-1){
                    System.out.println(false);
                    System.exit(0);
                }
                flag=false;
                add+=c;
            }
            
        }
        System.out.println(true);
        sc.close();
    
        
        
    }
}