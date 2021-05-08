package org.ice.lemon.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateNo26 {

    //nums is sorted , return value is the new length
    //[1, 1, 2, 2 ,3] -> [1, 2 ,3], 3
    public static int removeDuplicates(int[] nums) {
        //真正的index
        int index = 0;
//遍历数组的指针
        int i = 0;
        while (i < nums.length) {
            //如果i位置与i-1位置相等，则增加i
            //不等，则需要移动index，且要给index上赋值
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            nums[index] = nums[i];
            index++;
            i++;
        }
        if (index == 0) {
            return index + 1;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));

    }
}
