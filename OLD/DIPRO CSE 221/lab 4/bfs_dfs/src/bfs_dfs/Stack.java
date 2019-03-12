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
public interface Stack
{
    void push(int f);
    int pop();
    int peek();
    boolean isEmpty();
    int size();
    @Override
    String toString();
}
