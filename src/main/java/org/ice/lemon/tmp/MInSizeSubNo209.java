package org.ice.lemon.tmp;

public class MInSizeSubNo209 {
    /**
     * 求一个数组内 很尴尬
     * 最小的连续数组的和，能大于s
     * 应该需要使用滑动窗口，
     *很尴尬
     * 应该说从1遍历
     * 不断拓展有边界
     * 知道他大于s,
     * 转为左边界减少1，然后全
     * 如果然很大
     * 循环的每一次豆角三级片位加算一下
     * 初始化，都没有感觉
     * 随意第一次的值要在这里赋值
     * 所以我们要作恶是在
     * 一开始初始化，内容+1
     * Uzi可怕的是亲事情是
     *
     * 一开始的话，我们稚嫩却清left = 0
     * right = -1， sum 的话出师未0，res 的话出师未
     * @param s
     * @param nums
     * @return
     */
    public static int  minSubArrayLen(int s , int[] nums){
if(nums.length == 0){
    return 0;
}
int left = 0;
int right = -1;
int res = nums.length + 1;
int sum = 0;
while(left < nums.length){
    //需要将它遍历完
    //先去试探一下右边nengfoukuozhan
    if(right+1 < nums.length && sum < s ){
        right++;
        sum = sum + nums[right];
    }else{
        //or right 到了最边缘，sum已经完成条件
        //这次left一定得加上
        //加上可能有越界风险，所以下面计算的时候
        //sum没有风险，left有风险，线面判断的时候，要

        sum = sum - nums[left];
        //最后一次越界，sum 会等于0的
        left++;
    }
    if(sum >=s){
        res = Math.min(res, right -left +1);
    }
}
//遍历完了，如果发现res还是n+1
        if(res == nums.length +1){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(9, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
