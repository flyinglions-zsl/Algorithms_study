package leetcode.simple100;

/**
 * n & (n - 1) 即 n &= (n - 1) 实质是抹掉二进制最右边的 1 。
 * 举个栗子: n = 0100 1001，则 n - 1 = 0100 1000 n &= (n - 1) = 01001001 & 01001000 = 0100 1000，相当于打掉了 n 的二进制最右边的 0 ；由于相与的结果是 n = 01001000，不为 0 ，同样的操作继续，n 变为 0100 0000，不为 0 ，继续同样的操作后，n 变为 0 ；由于操作了三次，所以 n 转化为二进制里面有 3 个 1。
 *
 * n = 0100 1001
 * n - 1 = 0100 1000
 * n & (n - 1): 0100 1000 ------ n
 *
 * n = 0100 1000
 * n - 1 = 0100 0111
 * n & (n - 1): 0100 0000 ------ n
 *
 * n = 0100 0000
 * n - 1 = 0011 1111
 * n & (n - 1): 0 ------ n
 *
 */
public class 汉明距离 {

    public static void main(String[] args) {
        int res = distance(2, 12);
        System.out.println(res);
    }

    public static int distance(int x, int y) {
        int res = x ^ y;
        int distance = 0;
        while (res!=0){
            distance ++;
            res &= (res-1);
        }

        return distance;
    }

    public static int distance2(int x, int y) {
        int res = x ^ y;

        return Integer.bitCount(res);
    }
}
