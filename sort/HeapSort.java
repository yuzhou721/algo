import java.util.Arrays;

public class HeapSort {

    /**
     * 生成最大堆
     * @param arr
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[]arr , int parentIndex,int length){
        int temp = arr[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex<length){
//            选取两个节点当中最大的下标
            if (childIndex+1<length && arr[childIndex+1]>arr[childIndex]) {
                childIndex++;
            }
            if(temp>arr[childIndex]){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        arr[parentIndex] = temp;
    }

    public static void headSort(int[]arr){
        for (int i = (arr.length-2)/2; i >=0; i--) {
            downAdjust(arr,i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length-1; i  >0; i--) {
           int temp = arr[i] ;
           arr[i] = arr[0];
           arr[0] = temp;
           downAdjust(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
