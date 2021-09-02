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
    // ���캯��
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

    // ��������
    // ������ȫ������ �������ʾ�У� һ�� ������ʾ��Ԫ�� �� ���ڵ� ������
    public int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1)/2;
    }
    // ���� �� �ӽڵ� ������
    public int leafChile(int index){
        return index * 2 + 1;
    }
    // �������ӽڵ������
    public int rightChild(int index){
        return index * 2 + 2;
    }
    // ���ض��� Ԫ�ص� ����
    public int size(){
        return data.getSize();
    }
    // ���ض� �Ƿ�Ϊ��
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
    // �鿴���е����Ԫ��
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("can not findMax when heap is Empty.");
        return data.get(0);
    }
    // ɾ������Ԫ��
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // ά�� ��ȫ������������
        siftDown(0);
        return ret;
    }
    private void siftDown(int k){
        while(leafChile(k) < data.getSize()){
            int j = leafChile(k);
            if(j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            // ���� data[j] Ϊ���Һ����� �� max
            if(data.get(k).compareTo(data.get(j)) > 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }
    // ȡ������ ����Ԫ�أ� �����滻�� Ԫ�� e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
