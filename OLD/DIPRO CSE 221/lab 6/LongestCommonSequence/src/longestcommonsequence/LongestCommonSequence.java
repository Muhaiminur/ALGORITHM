/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestcommonsequence;

import java.util.Scanner;

/**
 *
 * @author Dipro
 */
public class LongestCommonSequence
{
    static int c [][];
    static char b[][];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //String X = "0ABCBDAB";
        //String Y = "0BDCABA";
        Scanner key = new Scanner(System.in);
        System.out.println("ENTER STRING 'X' ");
        String X = key.nextLine();
        System.out.println("ENTER STRING 'Y' ");
        String Y = key.nextLine();
        LCS_Length(X, Y);
        Print_LCS(b, X, X.length()-1, Y.length()-1);
    }
    public static void LCS_Length(String X, String Y)
    {
        c = new int[X.length()][Y.length()];
        b = new char[X.length()][Y.length()];
        int m = X.length();
        int n = Y.length();
        for (int i = 0; i < m; i++)
        {
            c[i][0] = 0;
        }
        for (int j = 0; j < n; j++)
        {
            c[0][j] = 0;
        }
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if(X.charAt(i)==Y.charAt(j))
                {
                    c[i][j] = (c[i-1][j-1])+1;
                    b[i][j] = 'C';
                }
                else if(c[i-1][j]>=c[i][j-1])
                {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 'U';
                }
                else
                {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 'L';
                }
            }
        }
    }
    
    public static void Print_LCS(char b[][],String X, int i, int j)
    {
        if(i==0||j==0)
        {
            return;
        }
        if(b[i][j] == 'C')
        {
            Print_LCS(b,X,i-1,j-1);
            System.out.println(X.charAt(i));
        }
        else if(b[i][j] == 'U')
        {
            Print_LCS(b,X,i-1,j);
        }
        else
        {
            Print_LCS(b,X,i,j-1);
        }
    }
}