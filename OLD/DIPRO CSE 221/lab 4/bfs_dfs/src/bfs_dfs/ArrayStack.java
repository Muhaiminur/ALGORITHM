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
public class ArrayStack implements Stack
{
  int [] array = new int [20];
  int top = 0;
  int size = 0;
  
  @Override
  public void push(int f)
  {
//    if(size == array.length)
//      array = resize(array);
    array[size]=f;
    top = f;
    size++;
  }
  
  @Override
  public int pop()
  {
    if(size == 0)
    {
      System.out.println("Stack Underflow !!!!!");
      return -111;
    }
    else
    {
      int temp = array[size-1];
      array[size-1] = 0;
      top = array[size-1];
      size--;
      return temp;
    }
  }
  
  @Override
  public int peek()
  {
    return top;
  }
  
  @Override
  public boolean isEmpty()
  {
    return (size==0);
  }
  
  @Override
  public int size()
  {
    return size;
  }
  
  @Override
  public String toString()
  {
    String msg = "|";
    for(int i=0; i<size-1; i++)
    {
      msg = msg+array[i]+"|";
    }
    return msg+array[size-1];
  }
}