package leetcode.simple100;

/**
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 *
 *
 * n & (n - 1) 即 n &= (n - 1) 实质是抹掉二进制最右边的 1 。
 * 举个栗子: n = 0100 1001，则 n - 1 = 0100 1000 n &= (n - 1) = 01001001 & 01001000 = 0100 1000，相当于打掉了 n 的二进制最右边的 0 ；
 * 由于相与的结果是 n = 01001000，不为 0 ，同样的操作继续，n 变为 0100 0000，不为 0 ，继续同样的操作后，n 变为 0 ；由于操作了三次，所以 n 转化为二进制里面有 3 个 1。
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
