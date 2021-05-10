package org.ice.lemon.array;

import java.util.Arrays;

public class ThreeSumCloseNo16 {

    //find the closet three sum  to target
   public static int  threeSumClosest(int[] nums,   int target){
       if(nums.length < 3){
           return 0;
       }
       int closestsum = nums[0] + nums[1] + nums[2];
       //先排序
       Arrays.sort(nums);
       // 确定第一个， 剩余两个余下找
       for(int i = 0 ; i < nums.length -2 ; i++){
           int tmpTarget = target - nums[i];
           int start = i +1;
           int end = nums.length -1;
           while(start < end){
               //计算当前的sum,更新closetSum
               int cursum = nums[i] + nums[start] + nums[end];
               if(Math.abs(target - closestsum) > Math.abs(target - cursum)  ){
                   closestsum = cursum;
               }
               //如果和
               if(nums[start] + nums[end] == tmpTarget){
                   return target;
               }else if(nums[start] + nums[end] < tmpTarget){
                   start++;
               }else {
                   end--;
               }

           }
       }
return  closestsum;
   }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
