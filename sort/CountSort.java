import java.util.Arrays;

public class CountSort {
    public static int[] sort(int[] arr){
//        取最大值
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >max){
                max = arr[i];
            }
        }
//      生成计数数组
        int[] countArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        int sortIndex=0;
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                sortArr[sortIndex++] = i;
            }
        }
        return sortArr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sorted = sort(array);
        System.out.println(Arrays.toString(sorted));
    }
}
