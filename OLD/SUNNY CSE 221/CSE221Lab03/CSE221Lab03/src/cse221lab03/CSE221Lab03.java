package cse221lab03;

public class CSE221Lab03 {

    static int[] list = {35, 56, 1, 148, 419, 250, 241, 42, 23, 29};

    public static void main(String[] args) {
        quickSort(0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "==");
        }
    }

    static void quickSort(int start, int end) {  
        int i = start;
        int j = end;

        int pivot = list[start + (end - start) / 2];

        while (i <= j) {

            while (list[i] < pivot) {
                i++;
            }

            while (list[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(start, j);
        }
        if (i < end) {
            quickSort(i, end);
        }
    }

    static void exchange(int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
