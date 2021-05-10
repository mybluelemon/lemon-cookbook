package org.ice.lemon.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class permutationNo46 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    //nums 1 2 3 4 5
    //排列问题，第一个位置5 ， 从当前位置，剩下的选一个，如何标识剩下

    /**
     * 一个就是每次我们都玄幻所有的数字，但是用一个used的数组，老保持，现阶段有些被用过了
     * 还有一种方法，就是保证遍历进行时中， 此及以后都是没用过的，
     * 所以要把正在遍历的这个位置的数字，和剩下所有的数字交换，保证这个地方遍历完了所有的可能
     * 剩下的位置都是没遍历过的
     * @param nums
     * @return
     */
    public static  List<List<Integer>>  permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, cur,used, res);
        backtrack2(nums, 0, res);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
        return res;
    }

    /**
     * nums: 原始数组
     * index： 当前遍历到的index，遍历到第几层了
     * cur: 现在遍历的结果中已经有的数字
     * used : 现在遍历的时候，还有那些数字还没用
     * 结束的时候，当index为最后一个时，复制完后就可以结束这个小分支的遍历了
     * @param nums
     * @param index
     * @param cur
     * @param used
     */
    public static void backtrack(int[] nums, int index, List<Integer> cur, boolean[] used, List<List<Integer>> res){

        if(index == nums.length ){
            //copy
            List<Integer> copy = new ArrayList<>(cur);
            res.add(copy);
            return;
        }

        for(int i = 0 ; i < nums.length ;  i++){
            //试试原数组这个位置的数字被使用了没有
            if(!used[i]){
                //
                used[i] = true;
                cur.add(nums[i]);
                backtrack(nums,index + 1, cur, used, res);
                cur.remove(index);
                used[i] = false;
            }
        }


    }


    //swap 方法
    public static void backtrack2(int[] nums, int index , List<List<Integer>> res){
        //
        if(index >= nums.length ){
           List<Integer> copy =  Arrays.stream(nums).boxed().collect(Collectors.toList());
           res.add(copy);
           return;
        }
        for(int i = index ; i < nums.length; i++){
            //swap
            swap(nums, index, i);
            backtrack2(nums, index +1 , res);
            swap(nums, index , i);
        }
    }

    public static void swap(int[] arr , int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
