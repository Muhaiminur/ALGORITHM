
public class countinversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] a={2,8,10,6,4,5,3,9};
        System.out.println(countInversion(a));
    }
    
    private static int count;
    private static int [] arr;
    public static int countInversion(int [] array){
        //System.arraycopy(array,0,arr,0,array.length);
        arr=new int[array.length];
        mergeSort(array,0,array.length-1);
        return count;
    }
    public static void mergeSort(int[] array,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            count=count+merge(array,low,high,mid);
        }
    }
    public static int merge(int[]array,int low,int high,int mid){
        int m=mid+1; int c=0;
        for(int i=low;i<=high;i++){
           arr[i]=array[i];
        }
        
        for(int i=low;i<=high;i++){
            if(low>mid)
                array[i]=arr[m++];
            else if(m>high)
                array[i]=arr[low++];
            else if(arr[low]<=arr[m])
                array[i]=arr[low++];
            else if(arr[low]>=arr[m]){
                array[i]=arr[m++];
                c=c+mid-low+1;
            }
        }
        return c;
    }
}
