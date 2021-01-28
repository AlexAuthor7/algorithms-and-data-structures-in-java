package linkedlist;

import stack.Stack;

/**
 * @Auther: Alex
 * @Date: 2021/1/9 - 01 - 09 -15:24
 * @Description: linkedlist
 * @Verxion: 1.0
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
