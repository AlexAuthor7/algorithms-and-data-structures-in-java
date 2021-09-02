package queue;

/**
 * @Auther: Alex
 * @Date: 2021/1/7 - 01 - 07 -19:12
 * @Description: qurue
 * @Verxion: 1.0
 */
public class LoopQueue3<E> implements queue.Queue<E> {
    private E[] data;
    //front 用于记录队首;tail用于记录队尾
    private int front,tail;
    private int size;

    public LoopQueue3 (int capacity){
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue3(){
        this(10);
    }
    public int getCapacity(){
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        if(tail == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 !=0){
            resize(getCapacity() /2 );
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
            //在循环队列中 角标与实际位置 存在 front 的偏移 ,为了防止角标越界 %data.length
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     在resize() 和 toString() 方法中，使用的遍历队列的方式是不一样的，但可以互相替换
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front[");
        for (int i = front; i != tail;i = (++i) % data.length) {
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
        //注意循环条件的写法 从front 开始，为防止脚标越界，i++之后再 %data.length
    }
    public static void main(String[] args){

        LoopQueue3<Integer> queue = new LoopQueue3<>();
        for(int i = 0 ; i < 20 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

        }
    }
}
