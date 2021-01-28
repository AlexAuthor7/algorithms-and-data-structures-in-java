package linearSearch;

/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -14:15
 * @Description: PACKAGE_NAME
 * @Verxion: 1.0
 */

public class LinearSearch {

    private LinearSearch(){}

    public static <E> int search(E [] data, E target){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] dataSize = {1000000,10000000};
        for(int n:dataSize){
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long start = System.nanoTime();//纳秒
            for (int i = 0;i < 100; i++) {
                LinearSearch.search(data,n);
            }
            long end = System.nanoTime();
            double time = (end-start)/1000000000.0;
            System.out.println("n = "+ n + ",100 runs " + time + "s");
        }
    }
}
