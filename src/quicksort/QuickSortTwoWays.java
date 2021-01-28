package quicksort;
import linearSearch.SortingHelper;
import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/11 - 01 - 11 -23:28
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSortTwoWays {
    private QuickSortTwoWays(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        //优化：我们只创建一次random的对象
        Random random = new Random();
        sort(arr,0,arr.length-1,random);
    }
    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r,Random random){
        if(r - l <= 8) {
            insertSort(arr,l,r);
            return;
        }
        //返回p的索引位置
        int p = partition(arr,l,r,random);
        // 对 arr[l,p-1]进行排序
        sort(arr,l,p-1,random);
        //对 arr[p+1,r]进行排序
        sort(arr,p+1,r,random);
    }
    public static <E extends Comparable<E>> int partition(E[] arr,int l,int r,Random random){
        // 生成一个[l,r]的随机值 ,先生成 [0,r-l] 再加上 l
        int p = random.nextInt(r-l+1) + l;
        //将 l 位置的元素 与 p 位置的元素进行交换,
        swap(arr,l,p);
        //初始化 i,j 的索引,实现 arr[l+1...i-1]<=v; arr[j+1...r]>=v
        int i = l + 1,j = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0)
                i++;
            while(j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;
            if(i >= j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }

    public static <E extends Comparable<E>> void swap (E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
    public static void main(String[] args) {
        int n = 1000000;
        SortingHelper.sortTest("MergeSort",n);
        SortingHelper.sortTest("MergeSortBU",n);
        SortingHelper.sortTest("QuickSort",n);
        SortingHelper.sortTest("QuickSortTwoWays",n);
    }
}