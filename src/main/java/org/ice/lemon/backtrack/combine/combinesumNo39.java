package org.ice.lemon.backtrack.combine;

import java.util.ArrayList;
import java.util.List;

public class combinesumNo39 {

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5},8);
    }

    /**
     * 要求一个组合，组合里的数可以无限复用，求所有sum 的组合
     * 终止条件是，target 已经小于0了，所以不需要有index了
     * 无限取用也不需要used
     * 这里面的index 不是层数
     * @param candidates
     * @param target
     * @return
     */
    public  static List<List<Integer>> combinationSum(int[] candidates, int target){

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,target,0, cur, res);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
        return res;
    }

    public static void backtrack(int[] nums, int target ,int index , List<Integer> cur, List<List<Integer>> res){
        if(target <= 0){
            if(target == 0){
                //hit copy
                List<Integer> copy = new ArrayList<>(cur);
                res.add(copy);
            }
            return;
        }

        for(int i = index ; i < nums.length ; i++){
            cur.add(nums[i]);
            backtrack(nums,target - nums[i],  i, cur,  res);
            cur.remove(cur.size()-1);
        }
    }
}
