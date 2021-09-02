package map;

/**
 * @Auther: Alex
 * @Date: 2021/3/11 - 03 - 11 -19:55
 * @Description: map
 * @Verxion: 1.0
 */
// K 必须是比较的
public class BinarySearchTreeMap<K extends Comparable<K>,V> implements Map<K,V> {

    // 定义节点
    private class Node {
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
    // 根节点
    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    // 向以node 为根的二分搜索树中插入 元素 e,递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,K key,V value) {
        // 终止条件
        if(node == null) {
            size++;
            return new Node(key,value);
        }
        // 继续递归
        if(key.compareTo(node.key) < 0) node.left = add(node.left,key,value);
        else if(key.compareTo(node.key) > 0) node.right = add(node.right,key,value);
        // 若出现相同的键
        else node.value = value;
        return node;
    }

    // 辅助方法，返回以 node 为根节点的二分搜索树中，key 所在的节点
    private Node getNode(Node node,K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) == 0) return node;
        else if (key.compareTo(node.key) < 0) return getNode(node.left,key);
        else return getNode(node.right,key);
    }
    @Override
    public V remove(K key) {
        return null;
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }
    @Override
    public V get(K key) {
        return getNode(root, key).value;
    }
    @Override
    public void set(K key, V newValue) {

    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
