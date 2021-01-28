package stack;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -18:47
 * @Description: Stack
 * @Verxion: 1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
