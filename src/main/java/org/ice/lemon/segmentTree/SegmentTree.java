package org.ice.lemon.segmentTree;

import java.util.Arrays;

public class SegmentTree {
    int[] st; //the array stores the segment tree

    //build the segment treee
    SegmentTree(int[] arr, int n ){
        //the height
        int x = (int) (Math.ceil(Math.log(n)/Math.log(2)));

        //the max size
        int max_size = 2 *(int) Math.pow(2,x) -1;
        st = new int[max_size];
        constructSTUTil(arr, 0, n-1, 0);
        for(int i : st){
            System.out.println(i);
        }
    }
    //ss start
    //se end
    //si cuurent index
    int constructSTUTil(int[] arr, int as, int ae, int si){
//how to build
        //
        if(as == ae){
            st[si] = arr[as];
            return arr[as];
        }
        //more than one , can divide
        int mid = getMid(as, ae);
        int leftChild = si * 2 + 1;
        int rightChild = si * 2 + 2 ;
        st[si] = constructSTUTil(arr, as,mid,leftChild) + constructSTUTil(arr, mid + 1, ae, rightChild );
        return st[si];

    }

    void print(){
        for(int i : st){
            System.out.println(i);
        }
    }
    int getMid(int s , int e){
        return  s +(e -s)/2;
    }

    void updateValue(int[] arr ,int i , int newValue){
        updateValueUtil(arr,0, arr.length -1, 0, i, newValue- arr[i]);
    }
    void updateValueUtil(int[] arr, int as ,int ae, int si, int i ,int diff){
if(i<as || i >ae || as == ae){
    return;
}
int leftChild = si * 2 +1;
int rightChild = si * 2 + 2;
int mid = getMid(as, ae);
st[si] = st[si] + diff;
updateValueUtil(arr, as, mid , leftChild, i, diff);
        updateValueUtil(arr, mid+1, ae , rightChild, i, diff);

    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 6, 11};
        SegmentTree  segmentTree =  new SegmentTree(arr, 6);
        segmentTree.updateValue(arr, 4, 9);
        segmentTree.print();

    }
}
