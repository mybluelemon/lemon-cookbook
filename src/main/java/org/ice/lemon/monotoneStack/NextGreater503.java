package org.ice.lemon.monotoneStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextGreater503 {

    /**
     * 现在很奇怪，
     * 现在要说每一个数字，在他之后的第一个比他大的，还要循环数组的感觉
     * 最简单的直觉开始循环了，如果你说，动态规划，有点道理，但是也很麻烦
     *
     * next greater 用 3 2 1 这种递减的来做，因为进来的都是比自己小，所以更不知道咋办，只能进来排队
     * 我们率先考虑单调栈来捉
     * 其实单调栈很奇怪，其实就是就一个排好序的东西，但是怎么书呢，他还维护者基本的循环顺序
     * stack里面存的都是些不确定还未找到答案的这些数字
     * 当一个数字进来后发现，栈顶元素很小，就告诉栈顶的及以后的这你们找到了，可以出栈了
     * 然后自己找不到 排着等着到末尾了，真的没了，栈里剩下的都是没有的
     * 循环的话，再来一圈，
     *
     * 数组有重复，栈里存index
     * 预先缓存一个第一个数字，他肯定得jinqv
     * stack
     * res
     * stack，add (0)
     * for(一从1遍历个数组的两编-1，遍历两遍)
     *对于每个元素，我们把都要检查，她对于栈内元素的贡献，检查完，加进去
     * 最后便利玩，把栈内的家伙都设置成-1
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums){

        if(nums.length == 0){
            return null;
        }
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums.length];
        for(int i = 0 ; i< nums.length ; i++){
            res[i] = -1;
        }
        stack.push(0);
        for(int i = 1 ; i < nums.length * 2 -1; i++){
            int index = i % nums.length;
            //check
            while (!stack.isEmpty() && nums[stack.peek().intValue()] < nums[index] ){
               res[stack.pop().intValue()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ints = nextGreaterElements(nums);
        for (int i : ints){
            System.out.println(i);
        }
    }
}
