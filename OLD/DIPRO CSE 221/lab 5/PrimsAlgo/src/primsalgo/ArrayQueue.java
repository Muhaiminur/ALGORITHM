/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primsalgo;

/**
 *
 * @author Dipro
 */
public class ArrayQueue implements Queue
{
    static int size = 0;
    static int [] q = new int [20];
    static int front =0;
    @Override
    public int size()
    {
        return size;
    }
    @Override
    public boolean isEmpty()
    {
        return size==front;
    }
    @Override
    public void enqueue(int o)
    {
        if(size==q.length)
        {
            System.out.println("Overflow");
        }
        else
        {
            q[size] = o;
            size++;
        }
    }
    @Override
    public int dequeue()
    {
        int temp=q[front];
        front = (++front)%q.length;
        return temp;
    }
    
    @Override
    public void priority(int a)
    {
        int temp = -1;
        for(int c=0; c<size; c++)
        {
            if(a==q[c])
            {
                temp=c;
                break;
            }
        }
        if(temp>=0)
        {
            int t = q[front];
            q[front] = q[temp];
            q[temp] = t;
        }
    }
    @Override
    public int peek()
    {
        return q[front];
    }
    @Override
    public String toString()
    {
        String str = "";
        for(int a=0; a<front; a++)
        {
            str = str+q[a]+" ";
        }
        return str;
    }
}