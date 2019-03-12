public class Mergesort2 {
    static int[] A={1,6,4,3,2,5};    
    static int count=0;
    
    public static void main (String[] args){        
        System.err.println("Unsorted numbers: ");
        for(int i : A)
            System.out.print(i+" ");
        //Sort the given array...
        mergesort(0, A.length - 1);
        //Sorting done...
        System.err.println("\nSorted numbers: ");
        for(int i : A)
            System.out.print(i+" ");
        System.err.println("\nInversions: "+ count);
    }
    static void mergesort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergesort(left, mid);   // Sorting left side...
            mergesort(mid + 1, right); // Sorting right side...
            count+=merge(left, right, mid); // Merging left & right, increasing counter...
        }
    }    
    static int merge(int left, int right, int mid) {    
        int[] B= new int[A.length];
        int i = left,
            j = mid + 1,
            count = 0;
        for (int x = left; x <= right; x++)
            B[x] = A[x];
        for (int x = left; x <= right; x++) {
            if (i > mid) 
                A[x] = B[j++];
            else if (j>right || B[i]<=B[j])
                A[x] = B[i++];
            else {
                A[x] = B[j++];
                count = count + mid - i + 1; // Counting the number of inversions
            }
        }
        return count; // Returning the count
    }
} 