package queue;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -20:10
 * @Description: qurue
 * @Verxion: 1.0
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
