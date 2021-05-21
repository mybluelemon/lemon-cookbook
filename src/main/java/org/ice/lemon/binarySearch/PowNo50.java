package org.ice.lemon.binarySearch;

public class PowNo50 {
    /**
     * 很尴尬，这儿是求一个x 的n 次方
     * 如果说这是3 * 18 次方，你可以搞 n -1
     * 先不用考虑溢出问题，可以说，二分的相乘
     * 很尴尬，
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            n = -n;
            return 1 / myPow(x, n);
        }
        double tmp = myPow(x, n >> 1);

        if ((n & 1) == 1) {
            return tmp * tmp * x;
        } else {
            return tmp * tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
    }
}
