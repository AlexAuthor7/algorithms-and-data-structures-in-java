package stack;

import array.Array;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -18:50
 * @Description: stack
 * @Verxion: 1.0
 */
public class ArrayStack<E> implements stack.Stack<E> {
    Array<E> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("Stack:");
        sbr.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            sbr.append(array.get(i));
            if(i != array.getSize() - 1){
                sbr.append(",");
            }
        }
        sbr.append("] top");
        return sbr.toString();
    }
}
