/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergeprob;

/**
 *
 * @author Dipro
 */
public class MergeProb
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] myArray = {2,8,9,3,5,1,6,4};
        System.out.println("Unsorted Array :");
        for(int x = 0;x<=myArray.length - 1;x++)
        {
            System.out.println(myArray[x]);
        }
        MergeSort(myArray,0,myArray.length-1);
        System.out.println("Sorted Array :");
        for(int x = 0;x<=myArray.length - 1;x++)
        {
            System.out.println(myArray[x]);
        }
    }
    
    public static void MergeSort(int[] myArray, int p, int q)
    {
        if(p<q)
        {
            int m = (p+q)/2;
            MergeSort(myArray, p, m);
            MergeSort(myArray, m+1, q);
            Merge(myArray, p, m, q);
        }
    }
    
    public static void Merge(int[] myArray, int l, int m, int r)
    {
        int nL = (m-l+1);
        int nR = r-m;
        
        int[] left = new int[nL+1];
        int[] right = new int[nR+1]; 
        
        for (int i = 0; i < nL; i++)
        {
            left[i]=myArray[l+i];
        }
        for (int i = 0; i < nR; i++)
        {
            right[i]=myArray[m+i+1];
        }
        
        left[nL]= Integer.MAX_VALUE;
        right[nR]= Integer.MAX_VALUE;
        
        int i = 0;  
        int j = 0;
        
        for (int k = l; k <= r; k++)
        {
            if (left[i]<=right[j])
            {
                myArray[k]=left[i];
                i++;
            }
            else
            {
                myArray[k]=right[j];
                j++;
            }
        }
    }
}