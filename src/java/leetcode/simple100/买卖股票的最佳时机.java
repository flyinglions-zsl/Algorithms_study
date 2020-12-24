package leetcode.simple100;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class 买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        //1判断后面是否有大于当前价格的情况
        //2一直找到后面大于自己 且差值最大的情况
        int profit=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++){
                if (prices[i] < prices[j]){
                    //每次都更新最大利润
                    profit = profit > (prices[j] - prices[i]) ? profit : (prices[j] - prices[i]);
                }
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int profit=0; //最大利润
        int min=Integer.MAX_VALUE; //最低价格
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int []nums = new int[]{7,6,4,3,1};
        System.out.println(maxProfit2(nums));
    }
}
