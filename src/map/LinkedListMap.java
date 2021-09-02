package map;


import set.FileOperation;
import set.LinkedListSet;
import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {
    // 创建内部类，定义节点
    private class Node {
        public K key;
        public V value;
        public Node next;

        // 节点的构造方法
        public Node(K key,V value,Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key) {
            this(key,null,null);
        }
        public Node() {
            this(null,null,null);
        }
        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
    // 虚拟头节点
    private Node dummyHead;
    private int size;
    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 私有方法，获取 键 为 key 的节点
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.key.equals(key)) return cur;
            cur = cur.next;
        }
        return null;
    }
    // 对于映射来说，键是唯一的，
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        // 若没有重复的键，创建一个，并维护 size
        if(node == null) {
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        // 如果键已经存在了，用 新值 替换 旧值
        else node.value = value;
    }
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null) {
            // 若 存在节点，跳出循环
            if(prev.next.key.equals(key)) break;
            // 向后移动节点
            prev = prev.next;
        }
        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        // 到这里表示 不存在 key
        return null;
    }
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }
    // 通过键来获取值
    @Override
    public V get(K key) {
        Node node = getNode(key);
        // 若为空 返回 null 否则返回 value
        return node == null ? null : node.value;
    }
    // 设置一个 键值对
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        // 若 key 不存在，抛出异常
        if(node == null) throw new IllegalArgumentException(key + "doesn't exist.");
        // 若 key 存在
        node.value = newValue;
    }

    // 测试方法，每个 单词出现的 个数
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        System.out.println();
    }
}
