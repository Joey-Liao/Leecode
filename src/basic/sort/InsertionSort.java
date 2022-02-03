package basic.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序思想：将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表
     * @param nums
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //记录下要插入的元素
            int temp=nums[i];
            int j=i;
            //找到第一个比该元素小的位置，并将比该元素大的后移一位，或到头
            while(j-1>0&&temp<nums[j-1]) {
                nums[j]=nums[j-1];
                j--;
            }
            //插入
            nums[j]=temp;
        }
    }
}
