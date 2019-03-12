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
public interface Queue
{
    int size();
    boolean isEmpty();
    void enqueue(int o);
    int dequeue();
    int peek();
    void priority(int a);
    @Override
    String toString();
}