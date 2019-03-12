
public class Mergesort
{
   public static void main(String[] args) {
	  int i;
      int[] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };
      System.out.println("Original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + " ");
      System.out.println();
      mergesort(data, data.length);
      System.out.println("Sorted array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + " ");
      System.out.println();
   }
   
   
   public static void mergesort(int[] data, int size)
   {
      int n1, n2;
      if (size > 1)
      {
         n1 = size / 2;
         n2 = size - n1;

         mergesort(data, n1);
         mergesort(data, n2);
         merge(data, n1, n2);
      }
   } 
  
   private static void merge(int[ ] data, int n1, int n2){
      int[ ] temp = new int[n1+n2];
      int copied  = 0;
      int copied1 = 0;
      int copied2 = 0;
      int i;
      while ((copied1 < n1) && (copied2 < n2))
      {
         if (data[copied1] < data[n1 + copied2])
            temp[copied++] = data[copied1++];
         else
            temp[copied++] = data[n1 + (copied2++)];
      }
      
      while (copied1 < n1)
         temp[copied++] = data[copied1++];
      while (copied2 < n2)
         temp[copied++] = data[n1 + (copied2++)];
      for (i = 0; i < n1+n2; i++)
         data[i] = temp[i];
   }
   
}

