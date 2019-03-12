package javaapplication5;

import java.util.Scanner;

public class JavaApplication5 {
    static int [] array= {1,5,4,8,10,2,6,9,12,11,3,7};
    static int v=-1;
    public static void main(String[] args) {
        /*Scanner k = new Scanner(System.in);
        System.out.println("How many integer(s) you want to insert?");
        int int1 = k.nextInt();
        int [] arra = new int [int1];
        for(int c = 0; c<arra.length; c++){
            arra[c]=k.nextInt();
        }
        array=arra;*/
        mergSort(array);
        for(int c0 = 0; c0<array.length; c0++)
            System.out.print(array[c0] + ", ");
        System.out.println();
        System.out.println(v);
    }
    static int [] mergSort(int [] temp){
        v++;
        int tempLength = temp.length;
        int [] arr1 = null, arr2 = null;
        if(tempLength>1){
            int tempLengthHalf=tempLength/2;
            arr1 = new int [tempLengthHalf];
            arr2 = new int [tempLength-tempLengthHalf];
            for(int c1 = 0; c1<arr1.length; c1++)
                arr1[c1]=temp[c1];
            for(int c2 = 0; c2<arr2.length;c2++)
                arr2[c2]=temp[c2+tempLengthHalf];
            temp=merge(mergSort(arr1),mergSort(arr2));
        }
        array=temp;
        return temp;
    }
    static int [] merge(int [] tempArr1, int [] tempArr2){
        int [] blank = new int [tempArr1.length+tempArr2.length];
        int l=0, r=0, c=0;
        while(l<tempArr1.length && r<tempArr2.length){
            if(tempArr1[l]<tempArr2[r]){
                blank[c]=tempArr1[l];
                c++;
                l++;
            }else{
                blank[c]=tempArr2[r];
                c++;
                r++;
            }
        }
        if(l>=tempArr1.length){
            for(int c5 = r; c5<tempArr2.length;c5++,c++)
                blank[c]=tempArr2[c5];
        }else{
            if(r>=tempArr2.length){
                for(int c6 = l; c6<tempArr1.length; c6++,c++)
                    blank[c]=tempArr1[c6];
            }
        }
        return blank;
    }
}
