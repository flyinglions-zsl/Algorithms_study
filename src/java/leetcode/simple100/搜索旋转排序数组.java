package leetcode.simple100;

public class 搜索旋转排序数组 {

    public static int getIndex(int []nums, int value){

        int i=0;
        int j=nums.length-1;
        while (i<=j){
            int middle = (i+j)/2;
            if (value == nums[middle]){
                return middle;
            }

            if (value > nums[middle]){
                i = middle+1;
            }

            if (value < nums[middle]){
                j = middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = new int[]{2,3,5,7,1,4};
        System.out.println(getIndex(nums,7));
    }
}
