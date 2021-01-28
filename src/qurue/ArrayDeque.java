package qurue;

/**
 * @Auther: Alex
 * @Date: 2021/1/7 - 01 - 07 -20:00
 * @Description: qurue
 * @Verxion: 1.0
 */
public class ArrayDeque<E> implements qurue.Deque<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;
    public ArrayDeque(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public ArrayDeque(){
        this(10);
    }

    @Override
    public void addFirst(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        front = front != 0 ? (--front) : (front = data.length - 1);
        data[front] = e;

        size++;
    }

    @Override
    public void addLast(E e) {
        if(isEmpty()){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front  = front != (data.length - 1) ? (++front):(front = 0);
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 !=0){
            resize(getCapacity() /2 );
        }
        return ret;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[tail - 1];
        data[tail - 1] = null;
        tail = tail != 0 ? (--tail) : (tail = data.length - 1);
        size--;

        return null;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public int getCapacity(){
        return data.length - 1;
    }
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("ArrayDeque: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail;i = (++i) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args){

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 10 ; i >= 0 ; i--){
            queue.addFirst(i);
            System.out.println(queue);
        }
        queue.addLast(11);
        System.out.println(queue);
        queue.removeFirst();
        System.out.println(queue);
        queue.removeLast();
        System.out.println(queue);
    }
}
