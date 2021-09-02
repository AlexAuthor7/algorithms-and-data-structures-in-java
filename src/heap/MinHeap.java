package heap;

import array.Array;

/**
 * @Auther: Alex
 * @Date: 2021-09-02 - 09 - 02 -14:50
 * @Description: heap
 * @Verxion: 1.0
 */
public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;
    // 构造函数
    public MinHeap(){
        data = new Array<>();
    }
    public MinHeap(int capacity){
        data = new Array<>(capacity);
    }
    // heapify
    public MinHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(data.getSize());i >= 0;i--)
            siftDown(i);
    }

    // size
    public int getSize(){
        return data.getSize();
    }
    // isempty
    public boolean isEmpty(){
        return data.getSize() == 0;
    }
    // 辅助函数
    public int parent(int index){
        return (index - 1) / 2;
    }
    public int leafChild(int index){
        return index * 2 + 1;
    }
    public int rightchild(int index){
        return index * 2 + 2;
    }
    // sift up
    public void add(E e){
        data.addLast(e);
        int k = data.getSize();
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMin(){
        return data.get(0);
    }

    public E extractMin(){
        E ret = findMin();
        // 删除最大元素
        data.swap(0, data.getSize());
        data.removeLast();
        siftDown(0);
        return ret;
    }
    public void siftDown(int k){
        while(leafChild(k) < data.getSize()){
            int j = leafChild(k);
            if(j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) < 0)
                j = rightchild(k);
            if(data.get(k).compareTo(data.get(j)) < 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }
    public E replace(E e){
        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
