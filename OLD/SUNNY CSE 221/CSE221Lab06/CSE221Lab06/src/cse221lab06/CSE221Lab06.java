package cse221lab06;

import java.util.Scanner;

/**
 *
 * @author SunNy
 */
public class CSE221Lab06 {

    static int[][] c;
    static String[][] p;
    static int m;
    static int n;
    static int length;
    static String s1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter First String");
        //s1 = sc.nextLine();
        s1="abaab";
        //System.out.println("Enter Second String");
        //String s2 = sc.nextLine();
        String s2="abab";
        c = new int[s1.length() + 1][s2.length() + 1];
        p = new String[s1.length() + 1][s2.length() + 1];
        m = s1.length();
        n = s2.length();
        

        for (int i = 0; i <= s1.length(); i++) {
            c[i][0] = 0;
        }

        for (int j = 0; j <= s2.length(); j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    p[i][j] = "diagonal";
                } else {
                    if (c[i - 1][j] > c[i][j - 1]) {
                        c[i][j] = c[i - 1][j];
                        p[i][j] = "up";
                    } else {
                        c[i][j] = c[i][j - 1];
                        p[i][j] = "left";
                    }
                }
                length = c[i][j];
            }
        }

        printTable();
        System.out.print("LCS: ");
        printLcs(m, n);
        System.out.println(" ");
    }

    static void printTable() {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The LCS length is:" + length);
    }

    static void printLcs(int x, int y) {
        if (x == 0 || y == 0) {
            return;
        } else if (p[x][y].equals("diagonal")) {
            printLcs(x - 1, y - 1);
            System.out.print(s1.charAt(x-1));
        } else if (p[x][y].equals("up")) {
            printLcs(x - 1, y);
        } else {
            printLcs(x, y-1);
        }

    }
}
