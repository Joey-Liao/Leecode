package basic.sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] tmp = new int[100010];
    public static void main(String[] args) {
        int[] nums = {1, 2, 7,33,9, 5, 8,2};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *归并排序的算法思想是：把数组从中间划分为两个子数组，一直递归地把子数组划分成更小的数组，直到子数组里面只有一个元素的时候开始排序。
     * 排序的方法就是按照大小顺序合并两个元素。接着依次按照递归的顺序返回，不断合并排好序的数组，直到把整个数组排好序。
     * @param nums
     * @param left
     * @param right
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if(left>=right) return;
        int mid=(left+right)>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right) {
            if(nums[i]<=nums[j]){
                tmp[k++]=nums[i++];
            }else{
                tmp[k++]=nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = left, k = 0; i <= right; i++,k++) {
            nums[i]=tmp[k];
        }
    }
}
