
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] xd={400,5,2,6,21,9,12,99,23,100,34};
		int[] res=mergeSorter(xd);
		
		for(int x:res)
			System.out.print(x+" ");
	}
	
	public static int[] mergeSorter(int[] data) {
		if(data.length<=1)
			return data;
		else {
			int mid=data.length/2;
			int[] left=java.util.Arrays.copyOfRange(data, 0, mid);
			int[] right=java.util.Arrays.copyOfRange(data, mid, data.length);
			left=mergeSorter(left);
			right=mergeSorter(right);
			return merger(left, right);
		}
	}
	
	public static int[] merger(int[] le, int[] ri) {
		int[] sorted=new int[le.length+ri.length];
		int k=0;
		while(le.length>0 && ri.length>0) {
			if(le.length>0 && ri.length>0) {
				if(le[0] < ri[0]) {
					sorted[k]=le[0];
	                le=java.util.Arrays.copyOfRange(le, 1, le.length);
	                k++;
				}
				else {
	                sorted[k]=ri[0];
	                ri=java.util.Arrays.copyOfRange(ri, 1, ri.length);
	                k++;
				}
			}
		}
		while(le.length>0) {
			sorted[k]=le[0];
            le=java.util.Arrays.copyOfRange(le, 1, le.length);
            k++;
		}
		while(ri.length>0) {
			sorted[k]=ri[0];
            ri=java.util.Arrays.copyOfRange(ri, 1, ri.length);
            k++;
		}
		
		return sorted;
	}

}
