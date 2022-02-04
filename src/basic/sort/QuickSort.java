package basic.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7,33,9, 5, 8,2};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思想：选择一个元素，使比该元素小的全部在它的左边，比它大的全部在它右边
     * @param nums
     * @param left
     * @param right
     */
    private static void quickSort(int[] nums,int left,int right) {
        if(left>=right) return;
        int start=left,end=right;
        int temp=nums[right];
        while(left<right){
            while(left<right&&nums[left]<=temp)
                left++;
            nums[right]=nums[left];
            while(left<right&&nums[right]>=temp)
                right--;
            nums[left]=nums[right];
        }
        nums[left]=temp;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);
    }
}
