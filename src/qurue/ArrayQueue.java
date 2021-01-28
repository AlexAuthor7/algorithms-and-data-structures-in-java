package qurue;

import array.Array;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -20:08
 * @Description: qurue
 * @Verxion: 1.0
 */
public class ArrayQueue<E> implements qurue.Queue<E> {
    Array<E> array;
    public ArrayQueue (int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue (){
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != getSize() - 1){
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < queue.getSize(); i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
