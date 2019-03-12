package cse221lab04;

import java.util.ArrayList;


public class Queue {
    ArrayList<Node> sList;
    
    Queue(){
        sList=new ArrayList<Node>();
    }
    
    void enque(Node n){
        sList.add(n);
    }
    
    public  Node dequeue(){
        Node r=sList.get(0);
        sList.remove(0);
        return r;
    }
    
    public boolean isEmpty(){
        return sList.isEmpty();
    }
}
