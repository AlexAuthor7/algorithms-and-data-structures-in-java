package mergesort;

import linearSearch.SortingHelper;

import java.util.Arrays;

/**
 * @Auther: Alex
 * @Date: 2021/1/10 - 01 - 10 -20:56
 * @Description: mergesort
 * @Verxion: 1.0
 */
public class MergeSort<E> {
    private MergeSort(){}
    public static <E extends Comparable> void sort(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }
    private static <E extends Comparable> void sort(E[] arr, int l, int r, E[] temp){
        if (r - l <= 16){
            insertSort(arr,l,r);
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);
    }
    private static <E extends Comparable> void merge(E[] arr, int l, int mid, int r, E[] aux){
        System.arraycopy(arr, l, aux, l, r - l + 1);
        int i = l, j = mid + 1;
        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){
            if(i > mid){
                arr[k] = aux[j]; j ++;
            }
            else if(j > r){
                arr[k] = aux[i]; i ++;
            }
            else if(aux[i].compareTo(aux[j]) <= 0){
                arr[k] = aux[i]; i ++;
            }
            else{
                arr[k] = aux[j]; j ++;
            }
        }
    }
    public static <E extends Comparable<E>>void insertSort(E[] arr,int l,int r){
        for (int i = l; i <= r; i++) {
            //将 arr[i] 插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i;j-1 >= l && temp.compareTo(arr[j-1]) < 0;j--)
                arr[j] = arr[j-1];

            arr[j] = temp;
        }
    }
    public static void main(String[] args){
        int n = 100000000;
        SortingHelper.sortTest("MergeSort",n);
    }
}