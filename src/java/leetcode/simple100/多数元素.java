package leetcode.simple100;

import java.util.Random;
import java.util.Stack;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class 多数元素 {

    public static int majorityElement(int[] nums) {

        Stack stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.contains(nums[i])) {
                stack.push(nums[i]);
            }
        }
        while (!stack.isEmpty()) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((int) stack.peek() == nums[i]) {
                    count++;
                }
            }
            if (count > (nums.length / 2)) {
                return (int) stack.peek();
            }
            stack.pop();
        }
        return -1;
    }

    /**
     * 随机法
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Random random = new Random();
        int first = 0;
        while (true) {
            //获取随机下标
            int index = getRandom(random, first, nums.length);
            //计算下标对应数组数据出现的次数
            int count = getCount(nums, nums[index]);
            //大于 n/2 则返回
            if (count > nums.length / 2) {
                return nums[index];
            }
        }
    }

    private static int getRandom(Random random, int i, int len) {
        //这里传0有点没懂。。
        return random.nextInt(len - i) + i;
    }

    private static int getCount(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement2(nums));
    }
}
