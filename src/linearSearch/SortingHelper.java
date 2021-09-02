package linearSearch;

import heap.HeapSort;
import insertSort.InsertSort;
import mergesort.MergeSort;

import mergesort.MergeSort3;
import quicksort.QuickSort;

import quicksort.QuickSort3Ways;
import quicksort.QuickSortFinal;

import quicksort.QuickSortTwoWays;
import selectionSort.SelectionSort;


/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -16:53
 * @Description: linearSearch
 * @Verxion: 1.0
 */
public class SortingHelper {
    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++)
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }


    /**
     * @Auther: Alex
     * @Description: 该方法用于测试排序算法对于 随机数组的性能
     * @Verxion: 1.0
     */
    public static <E extends Comparable<E>> void sortTest(String sortName, int i) {
        Integer[] data = ArrayGenerator.generateRandomArray(i, i * 100);
        long start = System.nanoTime();//纳秒
        //选择排序
        if (sortName == "SelectionSort")
            SelectionSort.sort(data);

        //插入排序(优化版)
        else if (sortName == "InsertSort")
            InsertSort.sort(data);

        //归并排序
        else if (sortName == "MergeSort")
            MergeSort.sort(data);
        else if (sortName == "MergeSortBU")
            MergeSort3.sortBU(data);

        //快速排序
        else if (sortName == "QuickSort")
            QuickSort.sort(data);

        else if (sortName == "QuickSortTwoWays")
            QuickSortTwoWays.sort(data);

        else if (sortName == "QuickSortThreeWays")
            QuickSort3Ways.sort(data);

        else if (sortName == "QuickSortFinal")
            QuickSortFinal.sort(data);

        else if (sortName == "HeapSort")
            HeapSort.sort(data);

        long end = System.nanoTime();
        if (!SortingHelper.isSorted(data)) {
            throw new RuntimeException("SelectionSort Failed");
        }
        double time = (end - start) / 1000000000.0;
        System.out.println(sortName + ":n = " + i + ":" + time + "s");
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){

        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertSort"))
            InsertSort.sort(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSortBU"))
            MergeSort3.sortBU(arr);
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSort2Ways"))
            QuickSortTwoWays.sort(arr);
        else if (sortname == "QuickSort3Ways")
            QuickSort.sort3ways(arr);
        else if (sortname == "QuickSortFinal")
            QuickSortFinal.sort(arr);
        else if (sortname == "HeapSort")
            HeapSort.sort(arr);
        else if (sortname == "HeapSort2")
            HeapSort.sort2(arr);


        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
//        if(!SortingHelper.isSorted(arr))
//            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }

    /**
     * @Auther: Alex
     * @Description: 该方法用于验证排序算法的时间复杂度
     * @Verxion: 1.0
     */
    public static <E extends Comparable<E>> void sortTest2(String sortName, int n) {
        int[] dataSize = {n, n * 10};
        for (int i : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(i, i * 100);

            long start = System.nanoTime();//纳秒
            //选择排序
            if (sortName == "SelectionSort") {
                SelectionSort.sort(data);
            }
            //插入排序(优化版)
            else if (sortName == "InsertSort") {
                InsertSort.sort(data);
            }
            //归并排序
            else if (sortName == "MergeSort") {
                MergeSort.sort(data);
            } else if (sortName == "MergeSortBU") {
                MergeSort3.sortBU(data);
            }

            if (!SortingHelper.isSorted(data)) {
                throw new RuntimeException("SelectionSort Failed");
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println(sortName + ":n = " + i + ":" + time + "s");
        }
    }
    /**
     * @Auther: Alex
     * @Description: 该方法用于验证排序算法对于有序数组的性能
     * @Verxion: 1.0
     */

    public static <E extends Comparable<E>> void sortTest3(String sortName, int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        long start = System.nanoTime();//纳秒
        //选择排序
        if (sortName == "SelectionSort") {
            SelectionSort.sort(data);
        }
        //插入排序(优化版)
        else if (sortName == "InsertSort") {
            InsertSort.sort(data);
        }
        //归并排序
        else if (sortName == "MergeSort") {
            MergeSort.sort(data);
        }
        //自底向上的归并排序
        else if (sortName == "MergeSortBU") {
            MergeSort3.sortBU(data);
        }
        //快速排序
        else if (sortName == "QuickSort") {
            QuickSort.sort(data);
        }
        else if (sortName == "QuickSort2") {
            QuickSort.sort2(data);
        }

        if (!SortingHelper.isSorted(data)) {
            throw new RuntimeException("SelectionSort Failed");
        }
        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        System.out.println(sortName + ":n = " + n + ":" + time + "s");


    }
}
