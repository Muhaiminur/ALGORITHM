/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primsalgo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dipro
 */
public class PrimsAlgo
{

    /**
     * @param args check command line argument
     */
    static Scanner key = new Scanner(System.in);
    static int [][] graph;
    static int [] w;
    static Object [] predecessor;
    static boolean [] check;
    
    public static void main(String[] args)
    {
        readfromfile();
        mst_Prim();
    }
    
    public static void readfromfile()
    {
        Scanner cat = null;
        try
        {
            cat = new Scanner(new File("Input.txt"));
            int p = cat.nextInt();
            int q = cat.nextInt();
            graph = new int [p][p];
            while(cat.hasNextLine()){
                p = cat.nextInt();
                q = cat.nextInt();
                int r = cat.nextInt();
                graph[p][q] = r;
                graph[q][p] = r;
            }
        }
        catch(NullPointerException | FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
    
    public static void mst_Prim()
    {
        ArrayQueue Q = new ArrayQueue();
        String str = "";
        String s = "";
        w = new int[graph.length];
        predecessor = new Object [graph.length];
        check = new boolean[graph.length];
        
        for(int i=0; i<w.length; i++)
        {
            w[i]=1000;
        }
        
        System.out.println("Starting Point:");
        int t = key.nextInt();
        w[t] = 0;
        predecessor[t]= -1;
        check[t]=true;
        System.out.println("|"+t+" | weight : "+w[t]+" | parent : "+predecessor[t]+"|");
        Q.enqueue(t);
        
        while(!Q.isEmpty())
        {
            int v = Q.dequeue();
            for(int c=0; c<graph[v].length; c++)
            {
                if(!check[c] && graph[v][c]>0 && w[c]>graph[v][c])
                {
                    Q.enqueue(c);
                    predecessor[c] = v;
                    w[c] = graph[v][c];
                    //t[r] = true;
                }
            }
            int u = extract_Min();
            Q.priority(u);
            if(u>=0)
            {
                System.out.println("|"+u+" | weight : "+w[u]+" | parent : "+predecessor[u]+"|");
            }
        }
    }
    
    public static int extract_Min()
    {
        int min = 1000000;
        int current = -1;
        for(int i=0; i<w.length; i++)
        {
            if(!check[i] && w[i]<min)
            {
                min = w[i];
                current = i;
            }
        }
        if(current>=0)
        {
            check[current]=true;
        }
        return current;
    }
}