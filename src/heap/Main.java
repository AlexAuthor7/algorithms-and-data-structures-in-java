package heap;

/**
 * @Auther: Alex
 * @Date: 2021-09-02 - 09 - 02 -12:09
 * @Description: heap
 * @Verxion: 1.0
 */
public class Main {
    public static void main(String[] args) {
        MaxHeap data = new MaxHeap();
        data.add(10);
        data.add(1);
        data.add(5);
        System.out.println(data);
        data.extractMax();
        System.out.println(data);
        data.add(10);
        data.add(20);
        System.out.println(data);
    }
}
