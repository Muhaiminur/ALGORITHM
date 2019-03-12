package cse221lab04;

import java.util.*;

public class CSE221Lab04 {

    static Node[] NodeList;
    static boolean[][] ver;
    static Queue queue;
    static Stack stack;

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        System.out.println("Enter first line");
        String fLine = m.nextLine();
        String fLineA[] = fLine.split(" ");
        int vertices = Integer.parseInt(fLineA[0]);
        int edges = Integer.parseInt(fLineA[1]);
        ver = new boolean[vertices][vertices];
        NodeList = new Node[vertices];

        for (int i = 0; i < vertices; i++) {
            NodeList[i] = new Node(i);
        }

        for (int i = 0; i < edges; i++) {
            System.out.println("enter vertexs");
            String line = m.nextLine();
            String lineA[] = line.split(" ");
            int a = Integer.parseInt(lineA[0]);
            int b = Integer.parseInt(lineA[1]);
            ver[a][b] = true;
            ver[b][a] = true;
        }
        printMatrix();
        Bfs(0);
        resetVisited();
        Dfs(0);
    }

    static void Bfs(int start) {
        queue = new Queue();
        queue.enque(NodeList[start]);
        NodeList[start].isVisited = true;
        enqueueChildren(start);
        Node n = queue.dequeue();
        System.out.print("BFS:" + n.value);
        BfsR();
    }

    static void BfsR() {
        while (!queue.isEmpty()) {
            Node n = queue.dequeue();
            System.out.print("," + n.value);
            enqueueChildren(n.value);
        }
        System.out.println();
    }

    static void enqueueChildren(int nodeIndex) {
        for (int i = 0; i < NodeList.length; i++) {
            if (ver[nodeIndex][i] == true) {
                if (!NodeList[i].isVisited) {
                    queue.enque(NodeList[i]);
                    NodeList[i].isVisited = true;
                }
            }
        }
    }

    static void printMatrix() {
        for (int i = 0; i < NodeList.length; i++) {
            for (int j = 0; j < NodeList.length; j++) {
                System.out.print(ver[i][j] + "||");
            }
            System.out.println("");
        }
    }

    //+++++++++++++++++++++++DFS++++++++++++++++++++++++++
    static void Dfs(int start) {
        stack = new Stack();
        stack.push(NodeList[start]);
        NodeList[start].isVisited = true;
        Node n = stack.pop();
        pushChildren(start);
        System.out.print("DFS:" + n.value);
        DfsR();
    }

    static void pushChildren(int nodeIndex) {
        for (int i = 0; i < NodeList.length; i++) {
            if (ver[nodeIndex][i] == true) {
                if (!NodeList[i].isVisited) {
                    stack.push(NodeList[i]);
                    NodeList[i].isVisited = true;
                }
            }
        }

    }

    static void DfsR() {
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print("," + n.value);
            pushChildren(n.value);
        }
        System.out.println();
    }
    
    static void resetVisited(){
        for (Node NodeList1 : NodeList) {
        NodeList1.isVisited=false;
        }
    }
}
