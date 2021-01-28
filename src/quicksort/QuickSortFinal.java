package quicksort;

import linearSearch.SortingHelper;


/**
 * @Auther: Alex
 * @Date: 2021/1/12 - 01 - 12 -16:52
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSortFinal {
    private QuickSortFinal(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }
    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        while(l < r){
            int i = l,j = r;
            do{
                while(arr[i].compareTo(arr[l]) < 0) i++;
                while(arr[j].compareTo(arr[l]) > 0) j--;
                if(i <= j) swap(arr,i++,j++);
            }while(i <= j);
            sort(arr,l,j);
            l = i;
        }
        return;
    }

    public static <E extends Comparable<E>> void swap (E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10;

        SortingHelper.sortTest("QuickSortFinal",n);
    }
}
