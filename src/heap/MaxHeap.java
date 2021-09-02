package heap;
import array.Array;
/**
 * @Auther: Alex
 * @Date: 2021-09-01 - 09 - 01 -19:34
 * @Description: heap
 * @Verxion: 1.0
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    // 构造函数
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }
    // heapify
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1);i >= 0;i--)
            siftDown(i);
    }

    // 辅助函数
    // 返回完全二叉树 的数组表示中， 一个 索引表示的元素 的 父节点 的索引
    public int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1)/2;
    }
    // 返回 左 子节点 的索引
    public int leafChile(int index){
        return index * 2 + 1;
    }
    // 返回有子节点的索引
    public int rightChild(int index){
        return index * 2 + 2;
    }
    // 返回堆中 元素的 个数
    public int size(){
        return data.getSize();
    }
    // 返回堆 是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }
    // shft up
    public void add(E e){
        data.addLast(e);
        int i = data.getSize() - 1;
        while(i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0){
            data.swap(i, parent(i));
            i = parent(i);
        }
    }
    // 查看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("can not findMax when heap is Empty.");
        return data.get(0);
    }
    // 删除最大的元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // 维护 完全二叉树的性质
        siftDown(0);
        return ret;
    }
    private void siftDown(int k){
        while(leafChile(k) < data.getSize()){
            int j = leafChile(k);
            if(j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            // 现在 data[j] 为左右孩子中 的 max
            if(data.get(k).compareTo(data.get(j)) > 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }
    // 取出堆中 最大的元素， 并且替换成 元素 e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
