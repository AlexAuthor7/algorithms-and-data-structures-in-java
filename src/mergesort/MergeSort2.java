package mergesort;

import linearSearch.ArrayGenerator;
import linearSearch.SortingHelper;

import java.util.Arrays;

/**
 * @Auther: Alex
 * @Date: 2021/1/10 - 01 - 10 -16:24
 * @Description: mergesort
 * @Verxion: 1.0
 */
public class MergeSort2<E>{
    private MergeSort2(){}

    public static <E extends Comparable<E>>void sort(E[] arr){
        sort(arr,0, arr.length-1,0);
    }
    public static <E extends Comparable<E>>void sort(E[] arr,int l,int r,int depth){
        //生成深度字符串
        String depthString = generateDepthString(depth);
        //打印当前 sort 要处理的数组的区间信息
        System.out.print(depthString);
        System.out.println(String.format("mergesort arr[%d,%d]",l,r));

        //最基本问题
        if(l >= r){
            return;
        }
        //获取中间值
        //有时候可能会出现 整形的溢出 所以我们改为减法
        int mid = l + (r - l) / 2;
        //分开进行排序
        sort(arr,l,mid,depth + 1);//深度 +1
        sort(arr,mid+1,r,depth + 1);

        //打印这次merge要处理的数组区间范围
        System.out.print(depthString);
        System.out.println(String.format("merge arr[%d,%d] and arr[%d,%d]",l,mid,mid+1,r));


        //对排好序的数组进行归并
        merge(arr,l,mid,r);

        //打印merge 后的数组
        System.out.print(depthString);
        System.out.print(String.format("after arr[%d,%d]",l,r));
        for(E e:arr){
            System.out.print(e + " ");
        }
        System.out.println();
    }



    //实现归并
    public static <E extends Comparable<E>>void merge(E[] arr,int l,int mid,int r){

        E[] temp = Arrays.copyOfRange(arr,l,r + 1);
        int i = l,j = mid + 1;
        for (int k = l; k <= r;k++) {

            //先考虑越界的情况
            if(i > mid){
                arr[k] = temp[j-l];
                j++;
            }else if(j > r){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l].compareTo(temp[j-l]) <= 0){
                arr[k] = temp[i-l];
                i++;
            }else{
                arr[k] = temp[j-l];
                j++;
            }
        }
    }

    private static String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("---");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Integer[] arr = {7, 1, 4, 2, 8, 3, 6, 5};
        sort(arr);
    }
}
