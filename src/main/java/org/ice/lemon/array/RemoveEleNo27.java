package org.ice.lemon.array;

public class RemoveEleNo27 {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            //
            if (nums[i] == val) {
                i++;
            } else {
                nums[index] = nums[i];
                i++;
                index++;
            }


        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}
