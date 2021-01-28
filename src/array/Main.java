package array;

/**
 * @Auther: Alex
 * @Date: 2021/1/4 - 01 - 04 -20:38
 * @Description: array
 * @Verxion: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);
    }
}
