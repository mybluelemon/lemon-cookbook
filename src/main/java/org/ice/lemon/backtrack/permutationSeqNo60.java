package org.ice.lemon.backtrack;

import java.util.ArrayList;
import java.util.List;

public class permutationSeqNo60 {

    public static void main(String[] args) {
        permutationSeq(3, 3);
    }

    /**
     * 1,2 ,3 ,4, ..n
     * 好处： 知道每个数组的排布了， 不用传 nums,
     *
     * @param n
     * @param k
     * @return
     */
    public static String permutationSeq(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        String[] res = new String[1];
        boolean[] used = new boolean[n];
        int[] karr = new int[1];
        karr[0] = k;
        backtrack(n, 0, cur, res, used, karr);
        System.out.println(res[0]);
        return res[0];
    }

    public static void backtrack(int n, int index, List<Integer> cur, String[] res, boolean[] used, int[] karr) {

        if (index == n) {
            System.out.println(1);
            //karr+1
            karr[0] -= 1;
            if (karr[0] == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer integer : cur) {

                    stringBuilder.append(integer);
                }
                res[0] = stringBuilder.toString();
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (karr[0] == 0) {
                return;
            }
            if (!used[i]) {
                used[i] = true;
                cur.add(i + 1);
                backtrack(n, index + 1, cur, res, used, karr);
                cur.remove(index);
                used[i] = false;

            }
        }
    }


}
