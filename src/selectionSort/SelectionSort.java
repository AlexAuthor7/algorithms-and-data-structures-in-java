package selectionSort;

import linearSearch.ArrayGenerator;
import linearSearch.SortingHelper;
import org.junit.jupiter.api.Test;

/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -15:44
 * @Description: selectionSort
 * @Verxion: 1.0
 */
public class SelectionSort {
    public static <E extends Comparable<E>> void sort(E[] data){

        for (int i = 0; i < data.length; i++) {

            int minIndex = i;
            for (int j = i; j < data.length ; j++) {
                if(data[j].compareTo(data[minIndex]) < 0){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                E temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int [] dataSize = {100,1000};
        for(int n:dataSize){
            Integer[] data = ArrayGenerator.generateRandomArray(n,n*100);
            long start = System.nanoTime();//纳秒

            sort(data);
            if(SortingHelper.isSorted(data)){
                throw new RuntimeException("SelectionSort Failed");
            }

            long end = System.nanoTime();
            double time = (end-start)/1000000000.0;
            System.out.println("n = "+ n + ":" + time + "s");
        }
    }
    @Test
    public void test(){
        int n = 100;
        Integer[] data = ArrayGenerator.generateRandomArray(n,n*100);
        System.out.println(SortingHelper.isSorted(data));
        sort(data);
        for(int e:data){
            System.out.print(e + " ");
        }
    }

}
