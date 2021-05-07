package org.ice.lemon.array;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSumNo1 {
    //return two nums index , and sum of them is target
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i = 0 ; i < nums.length; i++){
            int rest = target - nums[i];
            if(!hashMap.containsKey(rest)){
                //
                hashMap.put(nums[i],i);
            }else{
                return new int[]{hashMap.get(rest),i};
            }
        }
        return null;
    }
}
