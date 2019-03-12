/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package word_problem;

import java.util.*;
import java.io.*;
/**
 *
 * @author Dipro
 */
public class Word_Problem
{
    static ArrayList<String> a = new ArrayList();
    static ArrayList<String> output = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        read_from_file();
        sort();
        input();
        write();
    }

    private static void sort()
    {
        String temp = null;
        for(int i=0; i<a.size(); i++)
        {
            for(int j=i+1; j<a.size(); j++)
            {
                if(a.get(i).length()>a.get(j).length())
                {
                    temp = a.get(j);
                    a.set(j,a.get(i));
                    a.set(i,temp);
                }
            }
        }
    }

    private static void read_from_file()
    {
        try
        {
            Scanner sc = new Scanner(new File("A.txt"));
            for(;sc.hasNextLine();)
            {
                a.add(sc.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error!!!: "+e);
        }
    }

    private static void input()
    {
        try
        {
            Scanner sc = new Scanner (new File("Input.txt"));
            for(;sc.hasNextLine();)
            {
                String word = sc.nextLine();
                int b = count(word);
                int star = 0;
                int s = 0;
                for(int d=0;d<word.length();d++)
                {
                    if(word.charAt(d)!='*')
                    {
                        star++;
                    }
                }
                int x=0;
                for(;b<a.size();b++)
                {
                    s=0;
                    for(int c=0;c<word.length();c++)
                    {
                        if(word.length()==a.get(b).length() && word.charAt(c) != '*' && a.get(b).charAt(c) == word.charAt(c))
                        {
                            s++;
                        }
                        else if(word.charAt(c)!='*')
                        {
                            break;
                        }
                    }
                    if(star==s)
                    {
                        output.add(a.get(b));
                        output.add(",");
                        x++;
                    }
                }
                if(x==0)
                {
                    output.add("No_Match_Found");
                    output.add(",");
                }
                output.set(output.size()-1, ";");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ERROR: "+e);
        }
    }
    
    public static int count(String w)
    {
        int c = search(w);
        if(c>=0)
        {
            for(;a.get(c).length()==w.length();)
            {
                if(c==0)
                {
                    break;
                }
                if(a.get(c-1).length() == w.length())
                {
                    c--;
                }
                else
                {
                    break;
                }
            }
        }
        return c;
    }
    
    
    public static int search(String w)
    {
        int first = 0;
        int last = a.size() -1;
        int mid = (first+last)/2;    
        for(int i=0; i<=a.size(); i++)
        {
            if(a.get(mid).length()== w.length())
            {
                return mid;
            }
            else
            {
                if(a.get(mid).length()>w.length())
                {
                    last = mid;
                    mid = (first+last)/2;
                }
                else
                {
                    first = mid;
                    mid = (first+last+1)/2;
                }
            }
        }
        return -1;
    }

    private static void write()
    {
        try
        {
            PrintWriter p = new PrintWriter(new File("Output.txt"));
            for(int i=0; i<output.size()-1; i++)
            {
                p.print(output.get(i));
            }
            p.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error!!! : "+e);
        }
    }
}