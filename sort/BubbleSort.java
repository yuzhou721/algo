import java.util.Arrays;

public class BubbleSort {
    /**
     * 最简单的冒泡排序
     * @param data
     */
    public static void sort(int[] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
               int temp;
               if(data[j+1]<data[j]) {
                  temp=data[j+1];
                  data[j+1]=data[j];
                  data[j]=temp;
               }
            }
            System.out.println("第"+(i+1)+"轮");
        }
    }

    /**
     * 优化1 增加有序标识
     * @param data
     */
    public static void sort2(int[]data){
        for (int i = 0; i < data.length; i++) {
//            是否已经有序
            boolean isSorted=true;
            for (int j = 0; j < data.length - i - 1; j++) {
                int temp;
                if(data[j+1]<data[j]) {
                    temp=data[j+1];
                    data[j+1]=data[j];
                    data[j]=temp;
                    isSorted=false;
                }
            }
            System.out.println("第"+(i+1)+"轮");
            if(isSorted){
                break;
            }
        }

    }

    /**
     * 优化2 有序区域界定
     * @param data
     */
    public static void sort3(int[]data){
//            记录最后一次交换位置
        int lastExchangeIndex=0;
       // 无序数列边界
        int sortBorder=data.length-1;
        for (int i = 0; i < data.length; i++) {
//            是否已经有序
            boolean isSorted=true;

            for (int j = 0; j < sortBorder; j++) {
                int temp;
                if(data[j+1]<data[j]) {
                    temp=data[j+1];
                    data[j+1]=data[j];
                    data[j]=temp;
                    lastExchangeIndex=j;
                    isSorted=false;
                }
            }
            sortBorder=lastExchangeIndex;
            System.out.println("第"+(i+1)+"轮");
            if(isSorted){
                break;
            }
        }

    }

    /**
     * 鸡尾酒排序
     * @param data
     */
    public static void sort4(int[]data){
        for (int i = 0; i < data.length; i++) {
            System.out.println("第"+(i+1)+"轮");
//            是否已经有序
            boolean isSorted=true;
            for (int j = 0; j < data.length - i - 1; j++) {
                int temp;
                if(data[j+1]<data[j]) {
                    temp=data[j+1];
                    data[j+1]=data[j];
                    data[j]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
            isSorted = true;
            for (int j = data.length-i-1; j >i; j--) {
                int temp;
                if(data[j-1]>data[j]) {
                    temp=data[j-1];
                    data[j-1]=data[j];
                    data[j]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] sortData = new int[]{2,3,4,5,6,7,8,1};
        sort4(sortData);
        System.out.println(Arrays.toString(sortData));
    }
}

