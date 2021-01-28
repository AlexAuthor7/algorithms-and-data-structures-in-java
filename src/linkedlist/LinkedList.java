package linkedlist;

/**
 * @Auther: Alex
 * @Date: 2021/1/9 - 01 - 09 -13:53
 * @Description: linkedlist
 * @Verxion: 1.0
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }
    //获取链表中元素的个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表指定索引的地方插入元素
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;

    }

    //为链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e,head);
        add(0,e);

    }
    // 在链表的末尾添加元素
    public void addLast(E e){
        add(size,e);
    }
    //获取链表中索引为 index 的元素
    public E get (int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    //获取链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    //获取链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }
    //修改 index 位置的元素 为 e
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //查找链表中中是否存在元素 e 并返回索引 ,否则返回 -1
    public int Contains(E e){
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if(e.equals(cur.e)){
                return i;
            }
        }
        return -1;
    }
    //链表中元素的删除
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }
    //删除链表的第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除链表的最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size = %d\n",size));
        res.append("[");
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}
