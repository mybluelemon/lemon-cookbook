package org.ice.lemon.tmp;

public class TwoSumIINo167 {

    //很尴尬，如何球呢

    /**
     *其实应该判断数组是否大于两个数
     * start end
     * 每一次你去计算 两个和
     * 大于的话，end就减去1
     * 小于的话，start就加一
     * while的循环条件是《
     * 如果等于的话，直接return
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum167(int[] nums, int target) {

        if(nums.length < 2){
            return new int[] {-1, -1};
        }
        int start = 0 ;
        int end = nums.length-1;
        while(start < end){
           int tmp =  nums[start] + nums[end];
            if( tmp == target){
                return new int[]{start, end};
            }else if(tmp > target){
                end--;
            }else{
                start++;
            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(twoSum167(new int[]{2, 4, 7, 9, 10}, 9).toString());
    }
}
