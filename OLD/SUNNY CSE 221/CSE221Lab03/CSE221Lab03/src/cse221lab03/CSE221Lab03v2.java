
package cse221lab03;


public class CSE221Lab03v2 {
    static int [] list= {14,26,35,97,7,5,65,4,55,15};
    
    public static void main (String [] args){
        quickSort(0,list.length);
        System.out.println("sorted");
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
    }
    
    static void quickSort(int start, int end){
        if(start<end){
            int q=partition(start,end);
            quickSort(start,q-1);
            quickSort(q+1,end);
        }
    }

    static int partition(int start, int end) {
        int pivot=list[start];
        int i= start;
        
        for(int j=start+1;j<end;j++){
            if(list[j]<pivot){
                i=i+1;
                exchange(i,j);
            }
        }
        exchange(start,i);
        return i;
    }
    
    static void exchange(int i, int j){
        int temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }
}
