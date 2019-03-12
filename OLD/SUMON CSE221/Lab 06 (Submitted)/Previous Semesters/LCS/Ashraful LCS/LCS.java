
public class LCS {
  public static void main(String[] args) 
  {
     int length=0;
    String s1 = "ABCBDAB";
    String s2 = "BDCABA";
    int [][]c = new int[s1.length()+1][s2.length()+1];
    String [][]b = new String[s1.length()+1][s2.length()+1];
    
    for (int i=0; i<=s1.length(); i++){ 
      c[i][0] = 0;
    }
    for (int i=0; i<=s2.length(); i++){
      c[0][i] = 0;
    }
    for(int i = 1;i<=s1.length();i++){
      for(int j = 1;j<=s2.length();j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          c[i][j] = c[i-1][j-1]+1;
          b[i][j] = "diagonal";
        }
        else{
          if(c[i-1][j]>=c[i][j-1]){
            c[i][j] = c[i-1][j];
            b[i][j] = "up";
          }
          else{
            c[i][j] = c[i][j-1];
            b[i][j] = "left";
          }
        }
        length=c[i][j];  
      }
    }
    for(int i = 0;i<=s1.length();i++){
      for(int j = 0;j<=s2.length();j++){
        System.out.print(c[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("The length of LCS is " +length);
    printLCS(b,s1,s1.length(),s2.length());
    System.out.println();
  }
  public static void printLCS(String [][]bArr,String x,int i,int j){
    if(i==0 || j==0){
      return;
    }
    if(bArr[i][j].equals("diagonal")){
      printLCS(bArr,x,i-1,j-1);
      System.out.print(x.charAt(i-1));
    }
    else if(bArr[i][j].equals("up")){
      printLCS(bArr,x,i-1,j);
    }
    else{
      printLCS(bArr,x,i,j-1);
    }
  }
}
