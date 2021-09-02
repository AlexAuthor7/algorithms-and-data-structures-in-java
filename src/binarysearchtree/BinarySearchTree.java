package binarysearchtree;

import binarysearch.BinarySearch;

import java.util.*;

/**
 * @Auther: Alex
 * @Date: 2021/3/9 - 03 - 09 -13:53
 * @Description: binarysearchtree
 * @Verxion: 1.0
 */
// ��ʾ���� E Ҫ���пɱȽ���
public class BinarySearchTree<E extends Comparable<E>> {
    // �ڲ��࣬����ڵ�
    private class Node {
        public E e;
        public Node left,right;
        // ���캯��
        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    // ���ڵ�
    private Node root;
    // ���������� �洢��Ԫ�صĸ���
    private int size;

    // ���췽��
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // ��ȡ��ǰ�洢Ԫ�صĸ���
    public int size() {
        return size;
    }
    // �ж��Ƿ�Ϊ��
    public boolean isEmpty() {
        return size == 0;
    }
    // ��������������Ԫ�� e
    public void add(E e) {
        // ��� root Ϊ�գ���ֱ�ӷ���һ���ڵ�
        root = add(root,e);
    }
    // ���� node Ϊ���Ķ����������в���Ԫ�� E���ݹ��㷨
    // ���ز����½ڵ�� �����������ĸ�
    private Node add (Node node,E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        // ���뵱ǰ�ڵ����ڵ㣬�����ݹ飬�����صĽڵ���ڵ�ǰ ������ ��
        if(e.compareTo(node.e) < 0) node.left = add(node.left,e);
        // ���뵱ǰ�ڵ���ҽڵ㣬�����ݹ飬�����صĽڵ���ڵ�ǰ ������ ��
        else if (e.compareTo(node.e) > 0) node.right = add(node.right,e);
        return node;
    }

    // ���������������ǰ��� Ԫ�� e
    public boolean contains (E e) {
        return contains(root,e);
    }
    // ���� node Ϊ���Ķ������������Ƿ����Ԫ�� e ���ݹ��㷨
    private boolean contains(Node node,E e) {
        // �� node Ϊ�գ����� false
        if (node == null) return false;
        else {
            if(e.compareTo(node.e) == 0) return true;
            else if (e.compareTo(node.e) < 0) return contains(node.left,e);
            else return contains(node.right,e);
        }
    }
    // ������������ǰ�� ����
    public void preOrder() {
        preOrder(root);
    }
    // ǰ������� node Ϊ���Ķ������������ݹ����
    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // ������������ ���� ����
    public void inOrder() {
        preOrder(root);
    }
    // ��������� node Ϊ���Ķ������������ݹ����
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // ������������ ���� ����
    public void curOrder() {
        preOrder(root);
    }
    // ��������� node Ϊ���Ķ������������ݹ����
    private void curOrder(Node node) {
        if (node == null) return;
        curOrder(node.left);
        curOrder(node.right);
        System.out.println(node.e);
    }

    // ǰ������ķǵݹ�д�������� ջ �ṹ��������ȱ���
    public void preOrderNR() {
        // ���� java �е�ջ
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // �Ƚ����
            if (cur.right != null) stack.push(cur.right);
            // ����ȳ�
            if (cur.left != null) stack.push(cur.left);
        }
    }
    // ��������ķǵݹ�д�������� ���� �ṹ��������ȱ���
    public void levelOrder() {
        // ����java�е� ���� �ṹ
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }
    }

    // Ѱ�Ҷ�������������СԪ��
    public E minimum() {
        if(size == 0) throw new IllegalArgumentException("BinarySearchTree is empty!");
        return minimum(root).e;
    }
    // ������ node Ϊ���Ķ�������������Сֵ���ڵĽڵ�
    private Node minimum(Node node) {
        if(node.left == null) return node;
        return minimum(node.left);
    }
    // �Ӷ�����������ɾ����Сֵ���ڵĽڵ㣬������Сֵ
    public E removeMin() {
        E ret = minimum();
        // ���� root
        root = removeMin(root);
        return ret;
    }
    // ɾ������ node Ϊ���Ķ����������е���С�ڵ�
    // ����ɾ���ڵ���µĶ����������ĸ�
    private Node removeMin(Node node) {
        if(node.left == null) {
            // �����ҽڵ㣬�����ҽڵ��Ƿ�Ϊ null (null ҲΪ�ڵ��˼��)
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        // �ѷ��صĽڵ���ڵ�ǰ�ڵ�����
        node.left = removeMin(node.left);
        // û�о���ɾ�����������ص�ǰ�ڵ�
        return node;
    }


    // Ѱ�Ҷ��������������Ԫ��
    public E maximum() {
        if(size == 0) throw new IllegalArgumentException("BinarySearchTree is empty!");
        return maximum(root);
    }
    // ������ node Ϊ���Ķ��������������ֵ���ڵĽڵ�
    private E maximum(Node node) {
        if(node.left == null) return node.e;
        return maximum(node.left);
    }
    // �Ӷ�����������ɾ�����ڵ㣬�������ֵ
    public E removeMax() {
        E ret = maximum();
        // ���� root
        root = removeMax(root);
        return ret;
    }
    // ɾ������ node Ϊ���Ķ��������������ڵ�
    // ����ɾ���ڵ���µĶ����������ĸ�
    public Node removeMax(Node node) {
        // ����ǰ�ڵ���ҽڵ�Ϊ�գ��ýڵ����Ҫɾ���Ľڵ�
        if(node.right == null) {
            // ���浱ǰ�ڵ���ҽڵ�
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        // ��ǰ�ڵ㲻�� ���ֵ�������ݹ�,���ѷ��صĽڵ���� �ұ�
        node.right = removeMax(node.right);
        return node;
    }

    // ɾ������ڵ�
    public void remove(E e) {
        remove(root,e);
    }
    // ɾ������ node Ϊ���Ķ�����������ֵΪ e �Ľڵ㣬�ݹ��㷨
    //����ɾ����ڵ���µ� �����������ĸ�
    private Node remove(Node node,E e) {
        // Ѱ�ҽڵ�
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
            // �� node û��������
            if(node.left == null) {
                // ����������
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // �� node û��������
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // ��ɾ���ڵ�������������Ϊ�յ����
            // �ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ�
            // ������ڵ㶥���ɾ���ڵ��λ��
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right); // size���Ѿ��Ѿ� ά���� size ��
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }



    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        // ���� generateBSTString() ����,���� ���ڵ㣬��ʼ���0����������¼��ȵ� res
        generateBSTString(root,0,res);
        return res.toString();
    }
    // ������ node Ϊ���ڵ㣬���Ϊ depth ���������������ַ���
    private void generateBSTString(Node node,int depth,StringBuffer res) {
        // ���ڵ�Ϊ�գ����� ������ȵ� generateBSTString����� ���+null
        if(node == null) {
            res.append(generateBSTString(depth) + "null\n");
            return;
        }
        // ���� �����������+1��
        generateBSTString(node.left,depth + 1,res);
        // ����Ϊ�գ���� ���+�ڵ��ֵ
        res.append(generateBSTString(depth) + node.e + "\n");
        // ���� �����������+1
        generateBSTString(node.right,depth + 1,res);
    }
    // ���� ��� depth,�������
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
        // �����ܰ�˳��������׳��쳣
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)) throw new IllegalArgumentException("Error");
        }
        // ������������ȷ ������½��
        System.out.println("removeMin test completed.");
    }
}
