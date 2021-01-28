package array;



/**
 * @Auther: Alex
 * @Date: 2021/1/4 - 01 - 04 -19:57
 * @Description: 自定义的数组
 * @Verxion: 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;
    /**
     * @Description: 构造函数，传入的容量capacity构造Array
     */
    public Array(int capacity){
        //java中无法直接new 一个 E 类型的数组，需要我们new一个Object类型的数组，再进行类型转化
        data = (E[])new Object[capacity];
        size = 0;
    }
    /**
     * @Description: 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }
    /**
     * @Description: 获取数组中元素的个数 size
     */
    public int getSize(){
        return size;
    }
    /**
     * @Description: 获取数组的容量 capacity
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * @Description: 返回数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * @Description: 向数组的最后添加一个新的元素
     */
    public void addLast(E element){
        add(size,element);
    }
    /**
     * @Description: 向数组的开头添加一个新的元素
     */
    public void addFirst(E element){
        add(0,element);
    }

    /**
     * @Description: 向数组的Index索引处插入一个新元素
     */
    public void add(int index,E element){
        if(index < 0 || index > size){
            throw new RuntimeException("AddLast failed,Require index >= 0 and index <= size.");
        }

        if(size == data.length){
            resize(2 * data.length);

        }
        for(int i = size - 1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }
    /**
     * @Description: 遍历数组中的所有元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
    /**
     * @Description: 获取数组中索引为Index的元素
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new RuntimeException("Get failed,Index is illegal.");
        }
        return data[index];
    }
    /**
     * @Description: 修改index索引位置的元素为element
     */
    public void set (int index,E element){
        if(index < 0 || index > size){
            throw new RuntimeException("Set failed,Index is illegal.");
        }
        data[index] = element;
    }
    /**
     * @Description: 查找数组中是否存在元素element
     */
    public boolean contains(E element){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    /**
     * @Description: 查找数组中是否存在元素element,并返回他的索引,如果没找带，返回-1
     */
    public int find (E element){
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    /**
     * @Description: 删除数组中索引为Index 的元素,返回删除的元素
     */
    public E remove (int index){
        if(index < 0 || index > size){
            throw new RuntimeException("Remove failed,Index is illegal.");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;

        if(size == data.length / 4 && data.length/2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }
    /**
     * @Description: 删除数组中第一个的元素,返回删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }
    /**
     * @Description: 删除数组中第一个的元素,返回删除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }
    /**
     * @Description: 删除数组中第一个值为element的元素,返回删除的索引
     */
    public int removeElement(E element){
        int index = find(element);
        if(index != -1){
            remove(index);
            return index;
        }
        return -1;
    }
    /**
     * @Description: 当数组已满时，对数组进行扩容
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //让data 指向 newData
        data = newData;
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }
}
