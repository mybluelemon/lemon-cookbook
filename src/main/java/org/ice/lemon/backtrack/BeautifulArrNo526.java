package org.ice.lemon.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrNo526 {

    public static void main(String[] args) {
        System.out.println(countArrangement(4));
    }

    /**
     * 很奇怪，给定 1.。。n
     * 要求最终排列， 第i位数字，要被i整除，或i整除
     * 第i位数字 -》 arr[i-1] / i 或 i / arr[i-1]
     * 因为我们从0遍历 arr[i] / i+1 / arr[i]
     * 因为每一位都需要满足，所以我们需要在选定的时候剪纸
     *
     * @param n
     * @return
     */
    public static int countArrangement(int n) {
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[n];
        int[] res = new int[1];
        backtrack(n,0,cur,used, res);
        return res[0];

    }

    public static void backtrack(int n , int index, List<Integer> cur , boolean[] used, int[] res){
        if(index == n){
            //count + 1
            res[0] += 1 ;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(!used[i]){
                //开启剪枝
                //上述公式
                //当前是遍历的是index， 选定的是i+1
                if((i+1)%(index+1) != 0  &&  (index+1) % (i+1) != 0){
                    continue;
                }
                //剩下暂且表现良好
                used[i] = true;
                cur.add(i+1);
                backtrack(n, index+1,cur, used,res);
                cur.remove(index);
                used[i] = false;
            }
        }

    }

}
