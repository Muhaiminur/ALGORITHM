package cse221lab04;

public class Node {
    int value;
    public Node next;
    boolean isVisited=false;
    
    public Node(){
        
    }
    
    public Node(int value){
        this.value=value;
        isVisited=false;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int v){
        value=v;
    }
}
