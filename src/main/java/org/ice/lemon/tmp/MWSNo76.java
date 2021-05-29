package org.ice.lemon.tmp;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MWSNo76 {

    /**
     * 很尴尬，如何发现包含t出现了的全部字符捏
     * <p>
     * 我很尴尬这个东西只能
     * 这个右边的节点要不断扩大，除非已经全部包含了
     * 如果没包含全部，向右扩展，如果都不属于，继续
     * 如果属于也要继续扩展，而且
     * <p>
     * 如果全部包含了，很恐怖，达到条件了，需要记录现阶段的left ,right 作为res
     * 然后left要往右移了
     * <p>
     * 最后跳出的时机是需要left《n ,
     * 怎么初始化呢
     * right选中的话，其实0应该可以
     * 但是先判断是否所有的字母已经就位，
     * 如何判断所有字母已经就位，其实怎么说呢，需要一个原始的map
     * 记录t中出现的所有的字母的子树
     * tmpmap记录暂且出现的所有字母的次数
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
//初始化一下，left = 0, right， resleft ,resright,rawmap  tmpmap
        int left = 0;
        int right = -1;
        int resLeft = 0;
        int resRight = s.length();
        Map<Character, Integer> rawMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (rawMap.containsKey(c)) {
                rawMap.put(c, rawMap.get(c) + 1);
            } else {
                rawMap.put(c, 1);
            }
        }
        Map<Character, Integer> tmpMap = new HashMap<>();
        while (left < s.length()) {
            boolean check = isallContain(rawMap, tmpMap);
            if (!check && right+1 < s.length()) {
                //没有全部包含，这个right 需要加上
                if (tmpMap.containsKey(s.charAt(right+1))) {
                    tmpMap.put(s.charAt(right+1), tmpMap.get(s.charAt(right+1)) + 1);
                } else {
                    tmpMap.put(s.charAt(right+1), 1);
                }
                //加完了之后呢，right++
                right++;

            } else {
                //全部包含了这就非常恐怖,也可能是right 到了尽头
                //首先要记录现场的 left，right，有没有比res小
                if(check) {
                    if (resRight - resLeft > right - left) {
                        resLeft = left;
                        resRight = right;
                    }
                }
                //然后要右平移left
                tmpMap.put(s.charAt(left), tmpMap.get(s.charAt(left)) - 1);
                left++;
            }
        }
        if (resRight - resLeft == s.length()) {
            return "";
        }
        return s.substring(resLeft, resRight + 1);

    }

    public static boolean isallContain(Map<Character, Integer> rawMap, Map<Character, Integer> tmpMap) {
        for (Map.Entry<Character, Integer> entry : rawMap.entrySet()) {
            Character character = entry.getKey();
            if (tmpMap.get(character) == null || tmpMap.get(character) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
