package queue;

/**
 * @Auther: Alex
 * @Date: 2021/1/7 - 01 - 07 -17:59
 * @Description: qurue
 * @Verxion: 1.0
 */
public class LoopQueue2<E> implements queue.Queue<E> {
    private E[] data;
    //front 用于记录队首;tail用于记录队尾
    private int front,tail;


    public LoopQueue2 (int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;

    }
    public LoopQueue2(){
        this(10);
    }
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;

    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        if(getSize() == getCapacity() / 4 && getCapacity() / 2 !=0){
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
        return (getCapacity() + tail - front -1) % getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
            //在循环队列中 角标与实际位置 存在 front 的偏移 ,为了防止角标越界 %data.length
        }
        data = newData;
        front = 0;
        tail = getSize();
    }

    /**
     在resize() 和 toString() 方法中，使用的遍历队列的方式是不一样的，但可以互相替换
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n",getSize(),getCapacity()));
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

        LoopQueue2<Integer> queue = new LoopQueue2<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


}