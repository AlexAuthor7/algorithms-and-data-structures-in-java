package set;

/**
 * @Auther: Alex
 * @Date: 2021/3/10 - 03 - 10 -11:59
 * @Description: set
 * @Verxion: 1.0
 */
public interface Set <E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
