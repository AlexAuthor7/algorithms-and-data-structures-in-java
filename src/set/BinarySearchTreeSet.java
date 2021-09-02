package set;

import binarysearchtree.BinarySearchTree;

/**
 * @Auther: Alex
 * @Date: 2021/3/10 - 03 - 10 -14:11
 * @Description: set
 * @Verxion: 1.0
 */
// ��ʾ����ʱ�ɱȽϵ�
public class BinarySearchTreeSet <E extends Comparable<E>> implements Set<E> {
    //
    private BinarySearchTree<E> bst;

    // ������
    public BinarySearchTreeSet() {
        // ��ʵ������Ķ���ʱ����ȡһ�� ���������� ��BinarySearchTree���Ķ���
        bst = new BinarySearchTree<>();
    }
    // �򼯺ϻ������Ԫ�� e
    @Override
    public void add(E e) {
        bst.add(e);
    }
    // ɾ�������е���������
    @Override
    public void remove(E e) {
         bst.remove(e);
    }
    // ���������Ƿ���Ԫ�� e
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
    // ��ȡ���ϻ���Ԫ�صĸ���
    @Override
    public int getSize() {
        return bst.size();
    }
    // �жϼ����Ƿ�Ϊ��
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
