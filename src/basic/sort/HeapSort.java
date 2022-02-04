package basic.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 2,33,9, 5, 8};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     *堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
     * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     * @param nums
     */
    private static void heapSort(int[] nums) {
        //1.构建大顶堆
        for (int i = nums.length/2-1; i >= 0; i--) {
            //从第一个非叶子节点从上到下，从右到左开始调整结构
            adjustHeap(nums, i, nums.length);
        }
            //2.调整堆结构+交换堆顶元素与末尾元素
            for (int j = nums.length-1; j > 0; j--) {
                swap(nums,0,j);//将堆顶元素与末尾元素进行交换
                adjustHeap(nums,0,j);//重新对堆进行调整
            }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
