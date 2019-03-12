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
public class ArrayQueue implements Queue
{
    static int size = 0;
    static int [] q = new int [20];
    static int first = 0;
    @Override
    public int size()
    {
        return size;
    }
    @Override
    public boolean isEmpty()
    {
        return size==first;
    }
    @Override
    public void enqueue(int e)
    {
        if(size==q.length)
        {
            System.out.println("Overflow");
        }
        else
        {
            q[size] = e;
            size++;
        }
    }
    @Override
    public int dequeue()
    {
        int temp=q[first];
        first = (++first)%q.length;
        return temp;
    }
    @Override
    public int peek()
    {
        return q[first];
    }
    @Override
    public String toString()
    {
        String str = "";
        for(int i=0; i<first; i++)
        {
            str = str+q[i]+" ";
        }
        return str;
    }
}