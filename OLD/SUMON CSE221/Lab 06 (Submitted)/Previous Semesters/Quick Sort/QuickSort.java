package Quicksort;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array [] = new int[6];
	    for (int x=0;x<array.length;x++){
	      double z=Math.random()*100;
	      int y=(int)z;
	      array[x]=y;
	    }
	    System.out.println("Unsorted:");
	    for(int i=0; i<array.length; i++) {
	      System.out.print(array[i]+" ");
	    }
	    
	    quicksort(array,0,array.length-1);
	    System.out.println("\nSorted:");
	    for(int i=0; i<array.length; i++) {
	      System.out.print(array[i]+" ");
	    }

	}
	
	static int [] quicksort(int [] a,int left,int right){
	    if(left<right){
	      int q=partition(a,left,right);
	      quicksort(a,left,q-1);
	      quicksort(a,q+1,right);
	    }
	    return a;
	  }
	  
	  static int partition(int[] a,int left,int right){
	    int pivot=a[left];
	    int i=left;
	    
	    for(int j=left+1;j<a.length;j++){
	      if(a[j]<=pivot){
	        i=i+1;
	        int temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;
	      }
	    }
	    int hand=a[left];
	    a[left]=a[i];
	    a[i]=hand;
	    return i;
	  }
 
}
