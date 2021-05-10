package org.ice.lemon.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationNo47 {

    public static void main(String[] args) {
        permutation(new int[]{1,1,2});
    }
    public static List<List<Integer>> permutation(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,0, cur,used,res);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
        return res;
    }

    public static void backtrack(int[] nums, int index , List<Integer> cur, boolean[] used, List<List<Integer>> res){
        if(index == nums.length){
            //copy
            List<Integer> copy = new ArrayList<>(cur);
            res.add(copy);
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            //find the rest
            if(!used[i]){
                //去除重复的，只有第一次才能留下来, 前面的都用过才行，
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                //
                used[i] = true;
                cur.add(nums[i]);
                backtrack(nums,index+1,cur,used, res);
                cur.remove(index);
                used[i] = false;
            }
        }
    }
}
