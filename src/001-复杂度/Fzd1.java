
/**
 * 斐波那契数（当前数等于前两个数之和）
 * 0 1 1 2 3 5 8 13 21 。。。
 * */
public class Fzd1 {

    /**
     * 递归法实现
     * O(2^n)
     * */
    public static int fibnx1(int n){
        if (n <= 1)
            return n;
        return fibnx1(n-1) + fibnx1(n-2);
    }

    /**
     * for循环，找规律：
     * 0 1 1 2 3 5 8 13 21 。。。
     * 0 1 (n-1)+(n-2)定义为：开始数+结尾数
     * N1+N2 = N3(n=2时)，0为开始数，1为结尾数
     * N2+N3 = N4(n=3时)，N2为这次的开始数，N3为这次的结尾数，
     * N3+N4 = N5(n=4),N3为这次的开始数，N4为这次的结尾数,  --当前第n个的数为n+1的结尾数
     *
     * O(n)
     * */
    public  static int fibnx2(int n){
        if (n <= 1)
            return n;
        // 0 1 即为最初的开始数和结尾数，不然没意义
        int start = 0;
        int end = 1;
        int result = 0;
        for (int i = 0; i <n-1 ; i++) {
            result = start + end; //开始数+结尾数
            start = end;          // 先替换调下一次的开始数 即 上一次的结尾数
            end = result;         // 再替换调下一次的结尾数 即 result
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 40;
        TimeUtils.getRunningTime("fibnx1", new TimeUtils.Task() {
            @Override
            public void execute() {
                System.out.println(fibnx1(n));
            }
        });
        TimeUtils.getRunningTime("fibnx2", new TimeUtils.Task() {
            @Override
            public void execute() {
                System.out.println(fibnx2(n));
            }
        });
    }
}
