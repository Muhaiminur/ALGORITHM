package javaapplication6;

import java.util.Scanner;

/**
 *
 * @author Sumon E. H.
 */
public class JavaApplication6 {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.println("How many random numbers you want to be sorted?");
        int [] array = new int [k.nextInt()];
        for(int c = 0; c < array.length; c++){
            int d = (int) (Math.random()*100);
            array[c]=d;
        }
        System.out.print("Unsorted numbers: ");
        int c = 0;
        for(c = 0; c < array.length - 1; c++){
            System.out.print(array[c] + ", ");
        }
        System.out.println(array[c] + ".");
        quickSort(array, 0, array.length-1);
        System.out.print("Sorted numbers: ");
        for(c = 0; c < array.length - 1; c++){
            System.out.print(array[c] + ", ");
        }
        System.out.println(array[c] + ".");
    }
    static int [] quickSort(int [] arr, int left, int right){
        if(left < right){
            int q = partition(arr, left, right);
            quickSort(arr, left, q-1);
            quickSort(arr, q+1, right);
        }
        return arr;
    }
    static int partition(int [] a, int left, int right){
        int pivot = a[left];
        int i = left;
        for(int j = left+1; j<a.length; j++){
            if(a[j]<=pivot){
                i++;
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int t = a[left];
        a[left]=a[i];
        a[i]=t;
        return i;
    }
}
