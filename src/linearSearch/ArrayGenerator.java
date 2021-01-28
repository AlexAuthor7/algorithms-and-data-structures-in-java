package linearSearch;

import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -15:19
 * @Description: PACKAGE_NAME
 * @Verxion: 1.0
 */
public class ArrayGenerator {
    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * @Auther: Alex
     * @Description: 生成一个长度为 n 的随机数组，灭个数字的范围是 [0,bound)
     */
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }

}
