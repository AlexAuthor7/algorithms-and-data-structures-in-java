package insertSort;

import linearSearch.ArrayGenerator;
import linearSearch.SortingHelper;
import org.junit.jupiter.api.Test;

/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -17:43
 * @Description: insertSort
 * @Verxion: 1.0
 */
public class InsertSort {
    private InsertSort(){}
    public static <E extends Comparable<E>>void sort_Old(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j-1 >= 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                E temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

            }
        }
    }
    public static <E extends Comparable<E>>void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            //将 arr[i] 插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i;j-1 >= 0 && temp.compareTo(arr[j-1]) < 0;j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    public static <E extends Comparable<E>>void sort_reverse(E[] arr){
        for (int i = arr.length-1; i >= 0 ; i--) {
            E temp = arr[i];
            int j;
            for ( j = i;j + 1 < arr.length && temp.compareTo(arr[j+1]) > 0; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }



    public static void main(String[] args) {
        int [] dataSize = {100000,1000000};

        for(int n:dataSize){
            Integer[] data = ArrayGenerator.generateRandomArray(n,n*100);
            long start = System.nanoTime();//纳秒

            sort(data);
            if(SortingHelper.isSorted(data)){
                throw new RuntimeException("SelectionSort Failed");
            }
            long end = System.nanoTime();
            double time = (end-start)/1000000000.0;
            System.out.println("n = "+ n + ": " + time + "s");
        }
    }
    @Test
    public void test(){
        Integer[] arr = {13,34,6,345,26,3,5,4};
        sort_reverse(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
