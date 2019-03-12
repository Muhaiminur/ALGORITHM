
public class QuickSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa={2,6,3,9,8,12,54,0,5,23};
		quicksort(aa, 0, aa.length-1);
		for(int z:aa)
			System.out.print(z+" ");
	}
	
	public static void quicksort(int[] array, int left, int right) {
		if(left<right) {
			int pivotIndex=left+1;
			int pivotNewIndex = partition(array, left, right, pivotIndex);
			quicksort(array, left, pivotNewIndex - 1);
	        quicksort(array, pivotNewIndex + 1, right);
		}
		
		//return null;
	}
	
	public static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue=array[pivotIndex];
		int tmp=array[right];
		array[right]=array[pivotIndex];
		array[pivotIndex]=tmp;
		
		int storeIndex = left;
		for(int i=left; i<right; i++) {
			if(array[i] <= pivotValue) {
				int tmp2=array[i];
				array[i]=array[storeIndex];
				array[storeIndex]=tmp2;
				storeIndex++;
			}
		}
		int tmp3=array[storeIndex];
		array[storeIndex]=array[right];
		array[right]=tmp3;
		return storeIndex;
	}

}
