
import java.util.Scanner;
public class LongestCS {
  
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String X= sc.next();
    String Y = sc.next();
    int row = X.length();
    int col = Y.length();
    int m,n;
    
    int[][] ar = new int[row+1][col+1];
    int[][] B = new int[row+1][col+1];
    
    for (int i=0; i<=row; i++){ 
      ar[i][0] = 0;
    }
    for (int i=0; i<=col; i++){
      ar[0][i] = 0;
    }
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (X.charAt(i-1) == Y.charAt(j-1)){
          ar[i][j] = ar[i-1][j-1]+1;
         B[i][j]=1;  
      }
         else if (ar[i-1][j]>=ar[i][j-1]) {
                     ar[i][j]=ar[i-1][j];
                     B[i][j] = 2;  /* down */
                 }
                 else {
                     ar[i][j]=ar[i][j-1];     
                     B[i][j]=3;   /* forword */
                 }
      }
    }
    
    String lcs = new String();
         m=row;
         n=col;
         while (m!=0 && n!=0) {
             if (B[m][n] ==1) {   /* diagonal */
                 lcs =X.charAt(m-1) + lcs;
                 m = m- 1;
                 n= n - 1;
             }
             if (B[m][n] == 2) {  /* up */
                 m = m - 1;
             }
             if (B[m][n] == 3) {  /* backword */
                 n = n - 1;
             }
         }
         System.out.println("String X is " + X);
         System.out.println("String Y is " + Y);
         System.out.println("The length of LCS is " + ar[row][col]);
         System.out.println("The LCS is " + lcs);
  }
}