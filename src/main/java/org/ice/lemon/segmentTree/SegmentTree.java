package org.ice.lemon.segmentTree;

public class SegmentTree {
    int[] st; //the array stores the segment tree

    //build the segment treee
    SegmentTree(int[] arr, int n ){
        //the height
        int x = (int) (Math.ceil(Math.log(n)/Math.log(2)));

        //the max size
        int max_size = 2 *(int) Math.pow(2,x) -1;
        st = new int[max_size];

    }
    //ss start
    //se end
    //si cuurent index
    int constructSTUTil(int[] arr, int ss, int se, int si){
//how to build
        //
        if(ss == se){
            st[si] = arr[ss];
            return arr[ss];
        }
        //more than one , can divide
        int mid = getMid(ss, se);
        st[si] = constructSTUTil(arr, ss,mid,si * 2 +1) + constructSTUTil(arr, mid)

    }
    int getMid(int s , int e){
        return  s +(e -s)/2;
    }
}
