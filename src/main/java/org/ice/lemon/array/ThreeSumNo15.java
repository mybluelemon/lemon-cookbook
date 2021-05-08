package org.ice.lemon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumNo15 {
    //nums中三数之和为0，不能出现重复解，输出所有jie
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序，确定第一个，剩下两个从后面找，
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //如果i与前一位相等，跳过
            if (i > 0 && (nums[i - 1] == nums[i])) {
                continue;
            }
            int target = -nums[i];
            //目标，剩下的所有数中，找到和为target
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                //相等情况
                if (nums[start] + nums[end] == target) {
                    while (start + 1 < end && (nums[start] == nums[start + 1])) {
                        start++;
                    }
                    while (end - 1 > start && (nums[end] == nums[end - 1])) {
                        end--;
                    }

                    List<Integer> ele = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    res.add(ele);
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < target) {
                    //增大start
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.size());

    }
}
