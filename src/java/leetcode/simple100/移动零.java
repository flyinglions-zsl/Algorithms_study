package leetcode.simple100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class 移动零 {

    public static void moveZeroes(int[] nums) {
        int count=0,j=0;
        /**
         * 两个指针控制；将不为0的放到j 指针控制的下标， 遍历时 j<=i,不会打乱后面的顺序，并计算0出现的次数，再补位
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }else {
                count++;
            }
        }

        while (count!=0){
            nums[j++]=0;
            count--;
        }
    }


    public static void main(String[] args) {
        int []nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int i:nums){
            System.out.print(i+"  ");
        }
    }
}
