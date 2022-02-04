package basic.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        bubbleSort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /** 基 本 模 式
     1. 将序列当中的左右元素，依次比较，保证右边的元素始终大于左边的元素；
     （ 第一轮结束后，序列最后一个元素一定是当前序列的最大值；）
     2. 对序列当中剩下的n-1个元素再次执行步骤1。
     3. 对于长度为n的序列，一共需要执行n-1轮比较
     （利用while循环可以减少执行次数）
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }
    }

    /** 改 进 模 式
     *定义一个布尔变量 hasChange，用来标记每轮是否进行了交换。在每轮遍历开始时，将 hasChange 设置为 false。
     * 若当轮没有发生交换，说明此时数组已经按照升序排列，hasChange 依然是为 false。此时外层循环直接退出，排序结束。
     * @param nums
     */
    private static void bubbleSort1(int[] nums) {
        boolean hasChange=true;
        for (int i = 0; i < nums.length-1&&hasChange; i++) {
            hasChange=false;
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]) {
                    swap(nums,j,j+1);
                    hasChange=true;
                }
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
