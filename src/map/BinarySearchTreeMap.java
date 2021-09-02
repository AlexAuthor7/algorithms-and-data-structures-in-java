package map;

/**
 * @Auther: Alex
 * @Date: 2021/3/11 - 03 - 11 -19:55
 * @Description: map
 * @Verxion: 1.0
 */
// K �����ǱȽϵ�
public class BinarySearchTreeMap<K extends Comparable<K>,V> implements Map<K,V> {

    // ����ڵ�
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
    // ���ڵ�
    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    // ����node Ϊ���Ķ����������в��� Ԫ�� e,�ݹ��㷨
    // ���ز����½ڵ������������ĸ�
    private Node add(Node node,K key,V value) {
        // ��ֹ����
        if(node == null) {
            size++;
            return new Node(key,value);
        }
        // �����ݹ�
        if(key.compareTo(node.key) < 0) node.left = add(node.left,key,value);
        else if(key.compareTo(node.key) > 0) node.right = add(node.right,key,value);
        // ��������ͬ�ļ�
        else node.value = value;
        return node;
    }

    // ���������������� node Ϊ���ڵ�Ķ����������У�key ���ڵĽڵ�
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
