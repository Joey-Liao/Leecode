package basic.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7,33,9, 5, 8,2};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int maxPo=i;
            for (int j = i; j < nums.length; j++) {
                if(nums[j]<nums[maxPo])
                    maxPo=j;
            }
            swap(nums,i,maxPo);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
