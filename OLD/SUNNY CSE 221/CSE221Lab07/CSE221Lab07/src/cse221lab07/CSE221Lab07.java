package cse221lab07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * COMPLETE
 *
 * @author SunNy
 */
public class CSE221Lab07 {

    static int[][] c;
    static int[][] p;
    static int[] weight = new int[50];
    static int[] value = new int[50];
    static int size = 0;
    static int capacity;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\SunNy\\Documents\\NetBeansProjects\\CSE221Lab07\\src\\cse221lab07\\input.txt"));
        String line;
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\SunNy\\Documents\\NetBeansProjects\\CSE221Lab07\\src\\cse221lab07\\capacity.txt"));
        while ((line = reader.readLine()) != null) {
            insertIntoArray(line);
        }
        while ((line = reader2.readLine()) != null) {
            capacity = Integer.parseInt(line);
        }

        c = new int[size + 1][capacity + 1];
        p = new int[size + 1][capacity + 1];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i] > j) {
                    c[i][j] = c[i - 1][j];
                } else {
                    if (value[i] + max(i, j) > c[i - 1][j]) {
                        c[i][j] = value[i] + max(i, j);
                        p[i][j] = 1;
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                }
            }
        }
        printTable();
        System.out.println("+++++++++");
        printTableP();
        System.out.print("Solution: ");
        FindSol(size, capacity);
        System.out.println("");
    }

    static int max(int i, int cap) {
        int rem = cap - weight[i];
        //System.out.println("rem "+rem+" i:"+i+" j:"+cap);
        return c[i - 1][rem];
    }

    static void insertIntoArray(String line) {
        String arr[] = line.split(" ");
        weight[size + 1] = Integer.parseInt(arr[0]);
        value[size + 1] = Integer.parseInt(arr[1]);
        size++;
    }

    static void printTable() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= capacity; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void printTableP() {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= capacity; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.print("Weight: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(weight[i] + " ");
        }
        System.out.println(" ");

        System.out.print("Value: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println("");
    }

    static void FindSol(int i, int w) {
        if (i == 0) {
            return;
        }
        if (p[i][w] == 1) {
            FindSol(i - 1, w - weight[i]);
            System.out.print(i + " ");
        } else {
            FindSol(i - 1, w);
        }
    }
}
