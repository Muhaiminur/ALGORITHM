
public class MergSortCountInversion{
    static int arr[] =  {1,6,4,3,2};
    static int inv=0;
    
     public static void main(String []args){
      for(int i= 0;i<arr.length;i++){
            System.err.print(arr[i]+", ");
        }
        System.err.println();
        
        //***********Calling MergeSort****//
        mergeSort(arr);
        
        //***********View Sorted**********//
        for(int i= 0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
        System.err.println();
        System.err.println("The inversion is :"+inv);
    }
    
     public static int [] mergeSort(int [] temp){
        
        int n=temp.length;
        int L1[]=null;
        int L2[]=null;
        if(n>1){
            int m=(n/2);
            L1= new int[m]; //Making two divided list...
            for(int i= 0;i<L1.length;i++){
                L1[i]=temp[i];
            }
            L2= new int[n-m]; //Making two divided list...
            for(int i= 0;i<L2.length;i++){
                L2[i]=temp[i+m];
            }
            //Now recursively calling mergesort...
            //Merging the sorted lists...
            temp=merge(mergeSort(L1),mergeSort(L2));
        }
        arr=temp; //Replacing old non-sorted array... 
        return temp ;
    }
     
    public static int [] merge(int a[] , int b[]){
        
        //Making array length so that it covers all element...
        int newarr []= new int [a.length+b.length];
        int l=0; //Pointer for left array...
        int r=0; //Pointer for right array...
        int j=0;
        while(l<a.length && r<b.length){
            
            if(a[l]<b[r]){ //Maintaining increasing order sort...
                newarr[j]=a[l];
                l++;
                j++;
                
            }
            else{
                newarr[j]=b[r];
                r++;
                j++;
                inv= inv+(a.length-l);//Increment of inversion...
            }
        }
        if(r>=b.length){   //Appending rest of the elements if remains...
            for(int k=l;k<a.length;k++){
                newarr[j]=a[k];
                j++;
            }
        }
        else if(l>=a.length){//Appending rest of the elements if remains...
            for(int k=r;k<b.length;k++){
                newarr[j]=b[k];
                j++;
            }
        }
        return newarr; //Returning the merged array...
    }
    
   
}