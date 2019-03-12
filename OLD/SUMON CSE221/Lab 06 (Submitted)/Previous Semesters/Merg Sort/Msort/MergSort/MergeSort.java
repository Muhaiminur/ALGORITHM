public class MergeSort {
    
    static int[] newArray;
    static int[] tempArray;
    
    static void mergeSort(int[]a) {
        newArray=a;
        tempArray= new int[a.length];
        merge(0,a.length-1);
    }
    
    static void merge(int low, int high) {
        if(low<high) {
            int mid=(low + high)/2;
            merge(low, mid);
            merge(mid+1, high);
            sort(low, mid, high);
        }
    }
    
    static void sort(int low, int mid, int high) {
        for(int c=low; c<=high; c++) {
            tempArray[c]=newArray[c];
        }
        int i=low;
        int j=mid+1;
        int k=low;
        while (i <= mid && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                newArray[k] = tempArray[i];
                i++;
            }else {
                newArray[k] = tempArray[j];
                j++;
            } 
            k++;
        }
        while (i<=mid) {
            newArray[k] = tempArray[i]; 
            i++;
            k++;
        }
    }
    
    public static void main (String[]args) {
        int[]array={1,6,2,9,0};
        mergeSort(array);
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}