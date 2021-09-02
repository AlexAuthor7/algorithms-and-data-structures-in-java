package map;

/**
 * @Auther: Alex
 * @Date: 2021/3/11 - 03 - 11 -0:51
 * @Description: map
 * @Verxion: 1.0
 */
public interface Map<K,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set (K key ,V newValue);
    int getSize();
    boolean isEmpty();
}
