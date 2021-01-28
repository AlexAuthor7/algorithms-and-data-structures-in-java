package quicksort;

import linearSearch.SortingHelper;

/**
 * @Auther: Alex
 * @Date: 2021/1/11 - 01 - 11 -20:14
 * @Description: quicksort
 * @Verxion: 1.0
 */
public class QuickSort2 {
    private QuickSort2(){}
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1,0);
    }
    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r,int depth){
        if(l >= r) return;
        //查看 将要将要进行 Partition 的数组 和 区间信息
        System.out.print(generateDepthString(depth));
        System.out.print(String.format("first arr[%d,%d] ",l,r));

        for (int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int p = partition(arr,l,r,depth+1);

        //查看进行过portion的数组
        System.out.print(generateDepthString(depth));
        System.out.print(String.format("partition arr[%d,%d] ",l,r));
        for (int i = l; i <= r; i++) {
            if(i==p){
                System.out.print("["+arr[i]+"] ");
            }else{
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        // 对 arr[l,p-1]进行排序
        sort(arr,l,p-1,depth+1);
        //对 arr[p+1,r]进行排序
        sort(arr,p+1,r,depth+1);

        //查看排好序的数组
        System.out.print(generateDepthString(depth));
        System.out.print(String.format("final arr[%d,%d] ",l,r));
        for (int i = l; i <= r; i++) {
            if(i==p){
                System.out.print("["+arr[i]+"] ");
            }else{
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    //将 p 放在合适的位置 使左边的都比 p 小,右边的都比 p 大
    public static <E extends Comparable<E>> int partition(E[] arr,int l,int r,int depth){
        //把数组分为  arr[l] | arr(l+1,j) | arr(j+1,i-1) | arr[e] | arr(e+1,r) 的形式
        //初始化 j 的索引,
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
    public static <E extends Comparable<E>> void swap (E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //观察递归深度
    public static String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0;i <= depth;i++) {
            res.append("---");
        }
        return res.toString();
    }
    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,6,7,8,9};

        sort(arr);
        for(int a:arr){
            System.out.print(a + " ");
        }
    }
}
