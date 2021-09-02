package binarysearchtree;

import binarysearch.BinarySearch;

import java.util.*;

/**
 * @Auther: Alex
 * @Date: 2021/3/9 - 03 - 09 -13:53
 * @Description: binarysearchtree
 * @Verxion: 1.0
 */
// 表示类型 E 要具有可比较性
public class BinarySearchTree<E extends Comparable<E>> {
    // 内部类，定义节点
    private class Node {
        public E e;
        public Node left,right;
        // 构造函数
        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    // 根节点
    private Node root;
    // 二分搜索树 存储的元素的个数
    private int size;

    // 构造方法
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // 获取当前存储元素的个数
    public int size() {
        return size;
    }
    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 向二分搜索中添加元素 e
    public void add(E e) {
        // 如果 root 为空，会直接返回一个节点
        root = add(root,e);
    }
    // 向以 node 为根的二分搜索树中插入元素 E，递归算法
    // 返回插入新节点后 二分搜索树的根
    private Node add (Node node,E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        // 传入当前节点的左节点，继续递归，将返回的节点接在当前 左子树 上
        if(e.compareTo(node.e) < 0) node.left = add(node.left,e);
        // 传入当前节点的右节点，继续递归，将返回的节点接在当前 右子树 上
        else if (e.compareTo(node.e) > 0) node.right = add(node.right,e);
        return node;
    }

    // 看二分搜索树中是包含 元素 e
    public boolean contains (E e) {
        return contains(root,e);
    }
    // 看以 node 为根的二分搜索树中是否包含元素 e ，递归算法
    private boolean contains(Node node,E e) {
        // 若 node 为空，返回 false
        if (node == null) return false;
        else {
            if(e.compareTo(node.e) == 0) return true;
            else if (e.compareTo(node.e) < 0) return contains(node.left,e);
            else return contains(node.right,e);
        }
    }
    // 二分搜索树的前序 遍历
    public void preOrder() {
        preOrder(root);
    }
    // 前序遍历以 node 为根的二分搜索树，递归调用
    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的 中序 遍历
    public void inOrder() {
        preOrder(root);
    }
    // 中序遍历以 node 为根的二分搜索树，递归调用
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的 后序 遍历
    public void curOrder() {
        preOrder(root);
    }
    // 后序遍历以 node 为根的二分搜索树，递归调用
    private void curOrder(Node node) {
        if (node == null) return;
        curOrder(node.left);
        curOrder(node.right);
        System.out.println(node.e);
    }

    // 前序遍历的非递归写法，借助 栈 结构，深度优先遍历
    public void preOrderNR() {
        // 调用 java 中的栈
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 先进后出
            if (cur.right != null) stack.push(cur.right);
            // 后进先出
            if (cur.left != null) stack.push(cur.left);
        }
    }
    // 层序遍历的非递归写法，借助 队列 结构，广度优先遍历
    public void levelOrder() {
        // 调用java中的 队列 结构
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if(size == 0) throw new IllegalArgumentException("BinarySearchTree is empty!");
        return minimum(root).e;
    }
    // 返回以 node 为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if(node.left == null) return node;
        return minimum(node.left);
    }
    // 从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        // 更新 root
        root = removeMin(root);
        return ret;
    }
    // 删除掉以 node 为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            // 保存右节点，无论右节点是否为 null (null 也为节点的思想)
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        // 把返回的节点接在当前节点的左边
        node.left = removeMin(node.left);
        // 没有经历删除操作，返回当前节点
        return node;
    }


    // 寻找二分搜索树的最大元素
    public E maximum() {
        if(size == 0) throw new IllegalArgumentException("BinarySearchTree is empty!");
        return maximum(root);
    }
    // 返回以 node 为根的二分搜索树的最大值所在的节点
    private E maximum(Node node) {
        if(node.left == null) return node.e;
        return maximum(node.left);
    }
    // 从二分搜索树中删除最大节点，返回最大值
    public E removeMax() {
        E ret = maximum();
        // 更新 root
        root = removeMax(root);
        return ret;
    }
    // 删除掉以 node 为根的二分搜索树中最大节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMax(Node node) {
        // 若当前节点的右节点为空，该节点就是要删除的节点
        if(node.right == null) {
            // 保存当前节点的右节点
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        // 当前节点不是 最大值，继续递归,并把返回的节点接在 右边
        node.right = removeMax(node.right);
        return node;
    }

    // 删除任意节点
    public void remove(E e) {
        remove(root,e);
    }
    // 删除掉以 node 为根的二分搜索树中值为 e 的节点，递归算法
    //返回删除后节点的新的 二分搜索树的根
    private Node remove(Node node,E e) {
        // 寻找节点
        if(node == null) return null;
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e) > 0) {
            node.right =  remove(node.right,e);
            return node;
        }
        else { // e == node.e
            // 若 node 没有左子树
            if(node.left == null) {
                // 保存右子树
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 若 node 没有右子树
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right); // size中已经已经 维护过 size 了
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }



    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        // 调用 generateBSTString() 方法,传入 根节点，初始深度0，和用来记录深度的 res
        generateBSTString(root,0,res);
        return res.toString();
    }
    // 生成以 node 为根节点，深度为 depth 的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuffer res) {
        // 若节点为空，调用 生成深度的 generateBSTString，输出 深度+null
        if(node == null) {
            res.append(generateBSTString(depth) + "null\n");
            return;
        }
        // 访问 左子树，深度+1，
        generateBSTString(node.left,depth + 1,res);
        // 若不为空，输出 深度+节点的值
        res.append(generateBSTString(depth) + node.e + "\n");
        // 访问 右子树，深度+1
        generateBSTString(node.right,depth + 1,res);
    }
    // 生成 深度 depth,用于输出
    private String generateBSTString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) bst.add(random.nextInt(10000));
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()) nums.add(bst.removeMin());
        System.out.println(nums);
        // 若不能按顺序输出，抛出异常
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)) throw new IllegalArgumentException("Error");
        }
        // 若程序运行正确 输出以下结果
        System.out.println("removeMin test completed.");
    }
}
