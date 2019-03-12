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
public interface Queue
{
    int size();
    boolean isEmpty();
    void enqueue(int e);
    int dequeue();
    int peek();
    @Override
    String toString();
}
