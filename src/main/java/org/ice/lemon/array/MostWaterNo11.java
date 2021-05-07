package org.ice.lemon.array;

public class MostWaterNo11 {

    public int maxArea(int[] height){
        //
        int max =0 ;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            max = Math.max(max, Math.abs(height[left]-height[right])* (right - left));
            if(height[left] < height[right]){
                left++;
            }{
                right--;
            }
        }
        return max;
    }
}
