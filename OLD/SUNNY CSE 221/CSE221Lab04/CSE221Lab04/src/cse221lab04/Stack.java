package cse221lab04;

import java.util.ArrayList;


public class Stack {
    ArrayList<Node> sList;
    
    Stack(){
        sList=new ArrayList<Node>();
    }
    
    void push(Node n){
        sList.add(n);
    }
    
    public  Node pop(){
        Node r=sList.get(sList.size()-1);
        sList.remove(sList.size()-1);
        return r;
    }
    
    public boolean isEmpty(){
        return sList.isEmpty();
    }
}
