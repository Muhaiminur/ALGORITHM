/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weighted.problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dipro
 */
public class WeightedProblem
{
    static ArrayList weight = new ArrayList();
    static ArrayList value = new ArrayList();
    static int w = 0;
    static int item = 0;
    static int [][] k;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner on = new Scanner (new File("Values.txt"));
        
        w = on.nextInt();
        
        while(on.hasNextLine())
        {
            item = on.nextInt();
            weight.add(on.nextInt());
            value.add(on.nextInt());
        }
        
        k = new int [item+1][w+1];
        
        for(int i=1; i<k.length; i++)
        {
            for(int w=1; w<k[i].length; w++)
            {
                if((int)weight.get(i-1) <= (w))
                {
                    int a = (int)k[i-1][w];
                    int b =(int)k[i-1][w-(int)weight.get(i-1)]+(int)value.get(i-1);
                    
                    if(a > b)
                    {
                        k[i][w] = a;
                    }
                    
                    else
                    {
                        k[i][w] = b;
                    }
                }
                
                else
                {
                    k[i][w] = k[i-1][w];
                }
            }
        }
        
        System.out.println("Total volume = "+k[k.length-1][k[0].length-1]);
        knapsack(k.length-1,k[0].length-1);
        System.out.println();
    }

    private static void knapsack(int e, int f)
    {
        System.out.println(e+"="+f);
        if(e==0 || f==0)
        {
          System.out.print("Should Carry item no: ");
        }
        
        else if(k[e][f] != (k[e-1][f]))
        {
            knapsack(e-1, f-(int)weight.get(e-1));
            System.out.print(e+" ");
        }
        else
        {
            knapsack(e-1,f);
        }
    }
}