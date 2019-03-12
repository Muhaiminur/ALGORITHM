package cse221lab05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SunNy
 */
public class CSE221Lab05 {

    static Node[] NodeList;
    static int[][] ver;
    static int[][] mst;
    static ArrayList<Node> list = new ArrayList<>();
    static int visitCount = 0;
    static int[] minPath;

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        System.out.println("Enter first line");
        String fLine = m.nextLine();
        String fLineA[] = fLine.split(" ");
        int vertices = Integer.parseInt(fLineA[0]);
        int edges = Integer.parseInt(fLineA[1]);
        ver = new int[vertices][vertices];
        mst = new int[vertices][vertices];
        NodeList = new Node[vertices];
        minPath = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            NodeList[i] = new Node(i);
        }

        for (int i = 0; i < edges; i++) {
            System.out.println("enter vertexs");
            String line = m.nextLine();
            String lineA[] = line.split(" ");
            int a = Integer.parseInt(lineA[0]);
            int b = Integer.parseInt(lineA[1]);
            int c = Integer.parseInt(lineA[2]);
            ver[a][b] = c;
            ver[b][a] = c;
        }
        printMatrix();
        prim(0);
        printMST();
        minPath();
        for(int i=1;i<minPath.length;i++){
        System.out.println("0-"+i+":"+minPath[i]);
        }
    }

    static void printMatrix() {
        for (int i = 0; i < NodeList.length; i++) {
            for (int j = 0; j < NodeList.length; j++) {
                System.out.print(ver[i][j] + "||");
            }
            System.out.println("");
        }
        System.out.println("++++++++++++++++++");
    }

    static void printMST() {
        for (int i = 0; i < NodeList.length; i++) {
            for (int j = 0; j < NodeList.length; j++) {
                System.out.print(mst[i][j] + "||");
            }
            System.out.println("");
        }
    }

    static void prim(int nodeIndex) {
        list.add(NodeList[nodeIndex]);
        NodeList[nodeIndex].isVisited = true;
        int minW = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int i = 0; i < NodeList.length; i++) {
            if (ver[nodeIndex][i] > 0) {
                if (NodeList[i].isVisited == false) {
                    int tempMinW = ver[nodeIndex][i];
                    int tempMinN = i;
                    if (tempMinW < minW) {
                        minW = tempMinW;
                        minN = tempMinN;
                    }
                }
            }
        }
        mst[nodeIndex][minN] = minW;
        NodeList[minN].isVisited = true;
        visitCount++;
        list.add(NodeList[minN]);
        searchForMin();

    }

    static void searchForMin() {
        if (visitCount < NodeList.length) {
            int supMinW = Integer.MAX_VALUE;
            int supMinN = Integer.MAX_VALUE;
            int parent = Integer.MAX_VALUE;
            boolean found = false;
            for (int k = 0; k < list.size(); k++) {
                int m = list.get(k).value;
                int minW = Integer.MAX_VALUE;
                int minN = Integer.MAX_VALUE;
                int p = Integer.MAX_VALUE;
                for (int i = 0; i < NodeList.length; i++) {
                    if (ver[m][i] > 0) {
                        if (NodeList[i].isVisited == false) {
                            int tempMinW = ver[m][i];
                            int tempMinN = i;
                            if (tempMinW < minW) {
                                minW = tempMinW;
                                minN = tempMinN;
                                p = m;
                                found = true;
                            }
                        }
                    }
                }
                if (minW < supMinW) {
                    supMinW = minW;
                    supMinN = minN;
                    parent = p;
                }
            }
            if (found) {
                mst[parent][supMinN] = supMinW;
                NodeList[supMinN].isVisited = true;
                list.add(NodeList[supMinN]);
                visitCount++;
                found = false;
                searchForMin();
            }
        }
    }

    static void minPath() {
        minPath[0] = 0;
        for (int i = 0; i < NodeList.length; i++) {
            if (mst[0][i]>0) {
                minPath[i] = mst[0][i];
            }
        }
        for(int i=1;i<NodeList.length;i++){
            for(int j=0;j<NodeList.length;j++){
                if(mst[i][j]>0){
                    minPath[j]=minPath[i]+mst[i][j];
                }
            }
        }
    }
}

