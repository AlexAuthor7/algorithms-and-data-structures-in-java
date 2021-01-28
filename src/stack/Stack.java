package stack;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -18:48
 * @Description: Stack
 * @Verxion: 1.0
 */
public interface Stack<E>  {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
