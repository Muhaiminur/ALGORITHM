/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bfs_dfs;
/**
 *
 * @author Dipro
 */
import java.util.*;
import java.io.*;
public class BFS_DFS
{

    /**
     * @param args the command line arguments
     */
    
    static int [] []vertex;
    static Scanner sc;
    static int input;
    public static void main(String[] args)
    {
        input_t();
        DFS();
        BFS();
    }
    
    /*public static void input_k()
    {
        sc = new Scanner(System.in);
        System.out.println("Enter number of vertex and eadges");
        int a = sc.nextInt();
        int b=sc.nextInt();
        create(a,b);
    }*/
    
    public static void input_t()
    {
        try
        {
        sc = new Scanner(new File("Input.txt")) ;
        }
        catch(FileNotFoundException d)
        {
            System.out.println("Error : "+d);
        }
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        vertex = new int [a][a];
        
        while(sc.hasNextLine())
        {
            a = sc.nextInt();
            b = sc.nextInt();
            
            vertex[a][b]++;
            vertex[b][a]++;
        }
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Start Point");
        input = kb.nextInt();
        System.out.println();
    }
    
    public static void BFS()
    {
        boolean [] list = new boolean[vertex.length];
        ArrayQueue q = new ArrayQueue();
        q.enqueue(input);
        list[input]=true;
        String str = "";
        String st = ""+input+" | ";
        
        while(!q.isEmpty())
        {
            int n = q.dequeue();
            str = str +n+" ";
            list[n] = true;
            for(int c=0; c<vertex[n].length; c++)
            {
                if(vertex[n][c]>0 && !list[c])
                {
                    q.enqueue(c);
                    list[c]=true;
                    st = st+c+" ";
                }
            }
            st = st+"| ";
        }
        System.out.println("BFS order = "+str);
    }
    public static void DFS()
    {
        boolean [] list = new boolean[vertex.length];
        ArrayStack s = new ArrayStack();
        s.push(input);
        list[input] = true;
        String str = "";
        String st = ""+input+" | ";
        
        while(!s.isEmpty())
        {
            int n = s.pop();
            str = str +n+" ";
            //list[n]= true;
                
            for(int c=0; c<vertex[n].length; c++)
            {
                if(vertex[n][c]>0 && !list[c]){
                    s.push(c);
                    list[c] = true;
                    st = st+c+" ";
                }
            }
            st = st+"| ";
        }
        System.out.println("DFS order = "+str);
        System.out.println();
    }
}