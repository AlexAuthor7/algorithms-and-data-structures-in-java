package map;


import set.FileOperation;
import set.LinkedListSet;
import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {
    // �����ڲ��࣬����ڵ�
    private class Node {
        public K key;
        public V value;
        public Node next;

        // �ڵ�Ĺ��췽��
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
    // ����ͷ�ڵ�
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

    // ˽�з�������ȡ �� Ϊ key �Ľڵ�
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.key.equals(key)) return cur;
            cur = cur.next;
        }
        return null;
    }
    // ����ӳ����˵������Ψһ�ģ�
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        // ��û���ظ��ļ�������һ������ά�� size
        if(node == null) {
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        // ������Ѿ������ˣ��� ��ֵ �滻 ��ֵ
        else node.value = value;
    }
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null) {
            // �� ���ڽڵ㣬����ѭ��
            if(prev.next.key.equals(key)) break;
            // ����ƶ��ڵ�
            prev = prev.next;
        }
        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        // �������ʾ ������ key
        return null;
    }
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }
    // ͨ��������ȡֵ
    @Override
    public V get(K key) {
        Node node = getNode(key);
        // ��Ϊ�� ���� null ���򷵻� value
        return node == null ? null : node.value;
    }
    // ����һ�� ��ֵ��
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        // �� key �����ڣ��׳��쳣
        if(node == null) throw new IllegalArgumentException(key + "doesn't exist.");
        // �� key ����
        node.value = newValue;
    }

    // ���Է�����ÿ�� ���ʳ��ֵ� ����
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
