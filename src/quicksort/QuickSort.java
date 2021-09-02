package quicksort;
import linearSearch.SortingHelper;

import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/11 - 01 - 11 -17:13
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSort {
    private QuickSort(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        //优化：我们只创建一次random的对象
        Random random = new Random();
        sort(arr,0,arr.length-1,random);
    }
    public static <E extends Comparable<E>> void sort2(E[] arr){
        //优化：我们只创建一次random的对象
        Random random = new Random();
        sort2(arr,0,arr.length-1,random);
    }

    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r,Random random){
        if(l >= r) return;
        //返回p的索引位置
        int p = partition(arr,l,r,random);
        // 对 arr[l,p-1]进行排序
        sort(arr,l,p-1,random);
        //对 arr[p+1,r]进行排序
        sort(arr,p+1,r,random);
    }
    public static <E extends Comparable<E>> void sort2(E[] arr,int l,int r,Random random){
        if(l >= r) return;
        //返回p的索引位置
        int p = partition2(arr,l,r,random);
        // 对 arr[l,p-1]进行排序
        sort2(arr,l,p-1,random);
        //对 arr[p+1,r]进行排序
        sort2(arr,p+1,r,random);
    }
    //将 p 放在合适的位置 使左边的都比 p 小,右边的都比 p 大
    public static <E extends Comparable<E>> int partition(E[] arr,int l,int r,Random random){
        //把数组分为  arr[l] | arr(l+1,j) | arr(j+1,i-1) | arr[e] | arr(e+1,r) 的形式
        // 生成一个[l,r]的随机值 ,先生成 [0,r-l] 再加上 l
        int p = random.nextInt(r-l+1) + l;
        //将 l 位置的元素 与 p 位置的元素进行交换
        swap(arr,l,p);
        //初始化 j 的索引
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static <E extends Comparable<E>> int partition2(E[] arr,int l,int r,Random random){
        // 生成一个[l,r]的随机值 ,先生成 [0,r-l] 再加上 l
        int p = random.nextInt(r-l+1) + l;
        //将 l 位置的元素 与 p 位置的元素进行交换,
        swap(arr,l,p);
        //初始化 i,j 的索引,实现 arr[l+1...i-1]<=v; arr[j+1...r]>=v
        int j = l + 1,i = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0) i++;

            while(j >= i && arr[i].compareTo(arr[l]) > 0) j++;

            if(i >= j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }
    public static <E extends Comparable<E>> void sort3ways(E[] arr){
        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd){

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
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        int n = 1000000;

        SortingHelper.sortTest("QuickSort",n);
        SortingHelper.sortTest("QuickSort2",n);

    }
}
