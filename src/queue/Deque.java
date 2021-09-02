package queue;

/**
 * @Auther: Alex
 * @Date: 2021/1/7 - 01 - 07 -19:57
 * @Description: qurue
 * @Verxion: 1.0
 */
public interface Deque<E> {
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    E removeLast();
    E getFront();
    int getSize();
    boolean isEmpty();
}
