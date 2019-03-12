/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksortproblem;

/**
 *
 * @author Dipro
 */
public class QuickSortProblem
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int [] d = {6,11,8,16,26,18};
        System.out.println("Unsorted array: ");
        for(int h =0;h<d.length;h++)
        {
            System.out.println(d[h]);
        }
        QuickSort(d,0,d.length-1);
        System.out.println("Sorted array: ");
        for(int h =0;h<d.length;h++)
        {
            System.out.println(d[h]);
        }
    }

    private static int Partition(int[] d, int p, int q)
    {
        int x = d[p];
        int i = p;
        for(int j = p+1;j<=q;j++)
        {
            if(d[j]<=x)
            {
                i = i+1;
                int temp = d[i];
                d[i] = d[j];
                d[j] = temp;
            }
        }
        int n = d[p];
        d[p] = d[i];
        d[i] = n;
        return i;
    }

    private static void QuickSort(int[] d, int s, int t)
    {
        if(s<t)
        {
            int g = Partition(d,s,t);
            QuickSort(d,s,g-1);
            QuickSort(d,g+1,t);
            
        }
    }
    
}