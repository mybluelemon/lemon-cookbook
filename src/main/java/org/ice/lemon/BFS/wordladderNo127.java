package org.ice.lemon.BFS;

import java.util.*;

public class wordladderNo127 {

    /**
     * 很尴尬，如何从 beginword 到 endword
     * 每一步只变化一个字母，变化而成的字母在list 中，只能用一次
     * 一个单词的变化，变化出另外一个单词有很多种可能，
     * 可能存在三种可能，每种都继续下去，变化了之后，继续寻找下一个
     * 什么时候结束呢
     * 第一个是找到了，如何衔接
     * 第二个是depth有点问题，已经找的超过wordlist了我们还需要去排除一些用过的，有点像回溯
     * beiginword  endword  depth(线段长) visited
     * 初始化的beginword 它不在这个list 中，
     * 要不然说我们现行遍历beginword 的可能
     * 还是把beginword加入wordlist
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String  beginWord , String endWord , List<String> wordList ) {
//
        Map<String ,Integer> map = new HashMap<>();
        wordList.add(beginWord);
        for(String word : wordList){
            map.put(word, 0);
        }
        map.put(beginWord,1);
        int[] depth = new int[]{0};
        int res = backtrack(beginWord, endWord, depth, map);
        if(res == 0){
            return 0;
        }
        return depth[0] +1;
    }

    public static int backtrack(String beginword , String endword, int[] depth ,Map<String , Integer> wordMapVisited){
        if(depth[0] >= wordMapVisited.size()){
            //not found
            depth[0] = 0;
            return 0;
        }
        if(stringEquals(beginword,endword)){
            return 1;
        }

        List<String> candidates = getCandidates(beginword);
        for(String candidate : candidates){
            if(wordMapVisited.containsKey(candidate) && wordMapVisited.get(candidate) == 0){
                //没有被访问过，好存在，下面一这个词为起点开始寻找，寻找之前要干啥呢，寻找之后又要干啥呢，恢复现场
                wordMapVisited.put(candidate, 1);
                depth[0]++;
                int res = backtrack(candidate,endword,depth,wordMapVisited);
                if(res == 1){
                    return res;
                }
                depth[0]--;
                wordMapVisited.put(candidate, 0);

            }
        }
        return 0;
    }

    public static List<String> getCandidates(String beginword){
        List<String> res = new LinkedList<>();
        //小写字母
        for(char c = 'a'; c <= 'z'; c++){
            for(int i = 0 ; i < beginword.length(); i++){
                char[] chars = beginword.toCharArray();
                chars[i] = c;
                res.add(new String(chars));
            }
        }
        return res;
    }

    public static boolean stringEquals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        } else if (cs1 != null && cs2 != null) {
            if (cs1.length() != cs2.length()) {
                return false;
            } else if (cs1 instanceof String && cs2 instanceof String) {
                return cs1.equals(cs2);
            } else {
                int length = cs1.length();

                for(int i = 0; i < length; ++i) {
                    if (cs1.charAt(i) != cs2.charAt(i)) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String beginword = "hit";
        String endword =  "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(beginword, endword, wordList));

    }
}
