package org.ice.lemon.tmp;

import java.util.HashMap;
import java.util.Map;

public class LsmNo3 {
    /**
     * 很尴尬
     * 最长的不重复子串
     * 可以用滑动窗口
     * 需要一个hashmap存储过往的出现的所有的字符串的位置
     * 首先right无线的向右扩展
     * 试探只要rightt位出现的字母，在map中没出现过，或者map中的位置《left
     * 没事，len+1 max 比较一下进入下一次
     * 如果出现了就很尴尬，左边的你得左移了，而且，你需要找到，这个东西他的位置，左移
     * 到那儿—+1 len -
     * 跳出条件
     * @param s
     * @return
     */
    public static int  lengthOfLongestSubstring(String s) {
        if(s.length() <=1){
            return s.length();
        }
        int left = 0 ;
        int right = 0;
        int len = 0 ;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right < s.length()){
            //首先进入的right肯定符合规定
            if(!map.containsKey(s.charAt(right) )|| map.get(s.charAt(right)) < left){
                len = len +1 ;


            }else{
                //只能说已经含有了，怎么办
                //只能不断左移了
                Integer oldplace = map.get(s.charAt(right));
                len = len -(oldplace - left+1 );
                left = oldplace + 1;


            }
            res = Math.max(res, len);
            map.put(s.charAt(right), right);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

}
