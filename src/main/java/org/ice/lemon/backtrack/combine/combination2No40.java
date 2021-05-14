package org.ice.lemon.backtrack.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination2No40 {


    public static void main(String[] args) {
        combinationSum(new int[]{2,5,2,1,2}, 5);
    }
    //很尴尬，这个玩意儿是不能重复的， 不能重复需要两点，一个是排序
    //其实我们不需要used , 因为我们会从之后的选项选出下一个备选项
    //去除重复选项，还有一个重要的点是对比前后，这个时候必须需要used了
    //其实就是 ！used[i-1] && nums[i-1] == nums
    public  static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,0,target,cur,used,res);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
        return res;
    }

    public static void backtrack(int[] nums, int startIndex , int target ,  List<Integer> cur, boolean[] used ,List<List<Integer>> res){
        if(target <= 0|| startIndex == nums.length){
            if(target == 0){
                List<Integer> copy = new ArrayList<>(cur);
                res.add(copy);
            }
            return ;
        }

        for(int i = startIndex ; i < nums.length; i++){
            //循环找出剩下的一个
            if(i >0 && !used[i-1] && nums[i-1] == nums[i]){
                //去重
                continue;
            }
            used[i] = true;
            cur.add(nums[i]);
            backtrack(nums, i+1, target-nums[i], cur, used, res);
            cur.remove(cur.size() -1);
            used[i] = false;
        }
    }
}
