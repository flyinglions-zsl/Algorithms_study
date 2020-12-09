package leetcode.simple100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 */
public class 找到所有数组中消失的数字 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++){
            //这里每次的i循环都让其找到不同的替换，只能用当前数组num[i位置的数-1]控制找不同下标数据
            while(nums[i] != (i+1) && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i=0; i<nums.length; i++){
            if (nums[i] != (i+1)){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void swap(int []nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int []nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(nums);
        for (Integer in: res){
            System.out.println(in);
        }
    }
}
