package quicksort;

import linearSearch.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/12 - 01 - 12 -14:26
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSortThreeWays {
    private QuickSortThreeWays(){}
    static int[] res;
    public static <E extends Comparable<E>> void sort(E[] arr){
        //优化：我们只创建一次random的对象
        Random random = new Random();
        sort(arr,0,arr.length-1,random);
    }

    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r,Random random){
        if(l >= r) return;
        //获取 lt 和 gt 的索引位置

        //初始化 lt 和 gt 和 i 的索引
        int lt = l,gt = r + 1,i = l + 1;
        while (i < gt) {
            if(arr[i].compareTo(arr[l]) < 0) swap(arr,i++,++lt);
            else if(arr[i].compareTo(arr[l]) > 0) swap(arr,i,--gt);
            else i++; //arr[l] == arr[i]
        }
        swap(arr,l,lt);

        // 对 arr[l,lt-1]进行排序
        sort(arr,l,lt-1,random);
        //对 arr[gt,r]进行排序
        sort(arr,gt,r,random);
    }

    public static <E extends Comparable<E>> void swap (E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        SortingHelper.sortTest("MergeSort",n);
        SortingHelper.sortTest("MergeSortBU",n);
        SortingHelper.sortTest("QuickSort",n);
        SortingHelper.sortTest("QuickSortTwoWays",n);
        SortingHelper.sortTest("QuickSortThreeWays",n);
    }
}
