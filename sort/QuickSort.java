import java.util.Arrays;

public class QuickSort {

    /**
     * 分治 双循环
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] arr, int startIndex, int endIndex) {
//        跳过基准点选择过程，假设第一个元素为基准点
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
//            比较right指针元素，左移
            while (left < right && arr[right] >= pivot) {
                right--;
            }
//            比较left指针元素,右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
//            交换left 和right指针指向的元素
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            System.out.println("循环");
        }
//        指针重合，基准元素和重合点元素交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 分治 单循环
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition2(int[]arr,int startIndex,int endIndex){
       int pivot = arr[startIndex];
       int mark = startIndex;
//       从基准元素后一个开始循环
        for (int i = startIndex +1; i <= endIndex; i++) {
            if(arr[i]<pivot){
                mark++;
                int temp = arr[mark];
                arr[mark]=arr[i];
                arr[i] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex>=endIndex){
            return ;
        }
        int pivotIndex= partition2(arr, startIndex, endIndex);
//        小于基准点元素再拆分
        quickSort(arr,startIndex,pivotIndex-1);
//        大于基准点元素再次拆分
        quickSort(arr,pivotIndex+1,endIndex);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
