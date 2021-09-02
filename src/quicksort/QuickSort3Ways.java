package quicksort;
import linearSearch.ArrayGenerator;
import linearSearch.SortingHelper;

import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/12 - 01 - 12 -14:26
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSort3Ways {
    private QuickSort3Ways(){}
    public static <E extends Comparable<E>> void sort(E[] arr){

        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;

        /** 三路快速排序的 partition 过程 **/
        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt){
            if(arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i, lt);
                i ++;
            }
            else if(arr[i].compareTo(arr[l]) > 0){
                gt --;
                swap(arr, i, gt);
            }
            else{ // arr[i] == v
                i ++;
            }
        }
        swap(arr, l, lt);
        /** 三路快速排序的 partition 过程结束 **/
        // 递归调用
        sort(arr, l, lt - 1, rnd);
        sort(arr, gt, r, rnd);
    }
    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(1000, 1000);
        for(Integer i :data)
            System.out.print(i+" ");
        System.out.println();
        SortingHelper.sortTest("QuickSortThreeWays", data);
        for(Integer i : data)
            System.out.print(i+" ");
    }


}
