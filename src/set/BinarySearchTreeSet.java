package set;

import binarysearchtree.BinarySearchTree;

/**
 * @Auther: Alex
 * @Date: 2021/3/10 - 03 - 10 -14:11
 * @Description: set
 * @Verxion: 1.0
 */
// 表示泛型时可比较的
public class BinarySearchTreeSet <E extends Comparable<E>> implements Set<E> {
    //
    private BinarySearchTree<E> bst;

    // 构造器
    public BinarySearchTreeSet() {
        // 在实例化类的对象时，获取一个 二分搜索树 （BinarySearchTree）的对象
        bst = new BinarySearchTree<>();
    }
    // 向集合汇总添加元素 e
    @Override
    public void add(E e) {
        bst.add(e);
    }
    // 删除集合中的任意匀速
    @Override
    public void remove(E e) {
         bst.remove(e);
    }
    // 看集合中是否右元素 e
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
    // 获取集合汇总元素的个数
    @Override
    public int getSize() {
        return bst.size();
    }
    // 判断集合是否为空
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
