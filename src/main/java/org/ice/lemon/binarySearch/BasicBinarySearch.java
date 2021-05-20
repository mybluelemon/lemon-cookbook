package org.ice.lemon.binarySearch;

public class BasicBinarySearch {
    //返回target的index
    //很尴尬, 看你怎么search吧

    /**
     *
     * 首先取mid,(start + end )/2
     * mid 有可能和start一样，意味着和end 也一样
     * 每次看arr[mid] 和target的比较
     * 相等则返回
     * 如果arr[mid]比较大， 下一次搜索，end = mid-1 // 注意这儿可能index 会out,
     * 所以while 循环判断要注意， start 《= end
     * 为什么不要《 ，会漏掉start= end 情况， 这个还没有判断
     * 如果arr[mid]比较小，start = mid +1, 这儿也可能out
     * 如果都没搜索到，return -1
     *
     *
     * @param nums
     * @param target
     * @return
     */
   public static int binarySearchMatrix(int[] nums,  int target){
     int start = 0 ;
     int end = nums.length -1;
     while(start <= end){
         int mid = (start + end) /2;
         if(nums[mid] == target){
             return mid;
         }else if (nums[mid] > target){
             end = mid -1;
         }else{
             start = mid +1 ;
         }
     }
     return -1;
   }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 8};
        System.out.println(binarySearchMatrix(arr, 1));
    }
}
