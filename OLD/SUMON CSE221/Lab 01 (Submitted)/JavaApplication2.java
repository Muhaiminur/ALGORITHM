import java.io.*;
import java.io.File;
import java.util.Scanner;

public class JavaApplication2 {
    public static void main(String[] args)throws IOException {
        File f = new File("E:\\D.txt"); 
        Scanner k =new Scanner (f);
        Scanner p = new Scanner(System.in);
        String [] array= new String [100];
        String [] temp = new String[100];
        int c=0, t=0, g=0;
        while (k.hasNextLine()) {
            String s=k.nextLine();
            array[c]=s;
//            int lt = array[c].length();
//            System.out.println(array[c]);
            c++;
        }
        System.out.println("Enter word");
        String st = p.nextLine();
        int l = st.length();
        for (int n = 0; n < array.length; n++){
            if (array[n].length() == l){
                char ch[] = array[n].toCharArray();
                char arr[] = st.toCharArray();
                for (int q = 0; q < l; q++){
                    if(arr[q] == '*'){
                    }else{
                        if(arr[q]==ch[q]){
//                          if(g==1){
//                            g=0;
//                            break;
//                          }
                            temp[t]=array[n];
                            t++;
                            g++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        if(temp[0]!=null){
            for(int i = 0; temp[i]!=null; i++){
              System.out.print(temp[i]+", ");
              t--;
              if(i==t){
                System.out.print(temp[i]+".");
                break;
              }
            }
        }else{
            System.out.println("Not found");
        }
    }
}