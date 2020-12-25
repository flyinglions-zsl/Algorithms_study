package leetcode.simple100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 最大子序和 {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            res = Math.max(temp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(maxSubArray(nums));
    }
}
