package binarysearch;

/**
 * @Auther: Alex
 * @Date: 2021/1/12 - 01 - 12 -18:45
 * @Description: binarysearch
 * @Verxion: 1.0
 */
public class BinarySearch {
    private BinarySearch() {
    }

    /**
     * @Description ceil
     * û�� target,������Сֵ����
     * ��target,�����������
     *
     */

    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data,target);
        if(data[u-1].compareTo(target) == 0) return u-1;
        else return u;
    }
    /**
     * @Description lower_floor
     * �� target ��������С����
     * û�� targert , ���� lower
     */
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        // ע�⣬��Ϊ����Ҫ���� data[l + 1]�����ԣ�����Ҫ��ȷ�� l + 1 ��Խ�磬
        // �� l + 1 < data.length
        if(l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    /**
     * @Description upper_floor
     * �� target �������������
     * û�� targert , ���� upper
     */
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
        int l = -1,r = data.length - 1;
        return upper_floor(data,target,l,r);
    }
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target,int l,int r) {
        if(l >= r) return l;
        // Ϊ��ֹ��������μ��� ������l��r����ʱ��������Χ���ı�
        // �����ü�������� mid �ļ���ʱ�� ȡ��
        // �߽�
        int mid = mid = l + (r -l + 1) / 2;
        if (data[mid].compareTo(target) <= 0) return upper(data, target, mid - 1, r);
        else return upper(data, target, l, mid - 1);
    }
    /**
     * @Description lower
     * ����С�� target �����ֵ
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1,r = data.length - 1;
        return lower(data,target,l,r);
    }
    public static <E extends Comparable<E>> int lower(E[] data, E target,int l,int r) {
        if(l >= r) return l;
        // Ϊ��ֹ��������μ��� ������l��r����ʱ��������Χ���ı�
        // �����ü�������� mid �ļ���ʱ�� ȡ��
        // �߽�
        int mid = mid = l + (r -l + 1) / 2;
        if (data[mid].compareTo(target) >= 0) return upper(data, target, l, mid-1);
        else return upper(data, target, mid, r);
    }


    /**
     * @Description lower����ceil
     * Ѱ�� ���ڵ��� target ����С����
     */
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0,r = data.length;
        return lower_ceil(data,target,l,r);
    }
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target, int l, int r) {
        if(l >= r) return r;
        int mid = (r - l) / 2 + l;
        // mid ���ڵ��� target ʱ���� mid ��Ϊ r ���� lweor_ceil
        if (data[mid].compareTo(target) >= 0) return lower_ceil(data,target,l,mid);
        // mid С�ڵ��� target ʱ���� mid ������ �� mid+1 ��Ϊ l ����
        else return lower_ceil(data,target,mid+1,r);
    }

    /**
     * @Description �����Ķ��ֲ���
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        return search(data, target, 0, data.length - 1);
    }
    public static <E extends Comparable<E>> int search(E[] data, E target, int l, int r) {
        if (l > r) return -1;

        int mid = (r - l) / 2 + l;
        if (data[mid].compareTo(target) == 0) return mid;
        if (data[mid].compareTo(target) < 0) return search(data, target, mid + 1, r);
        return search(data, target, l, mid - 1);
    }
    /**
     * @Description lower����ceil
     * Ѱ�Ҵ��� target ����С����
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0,r = data.length;
        // �� data[l,r]��Ѱ�ҽ�
        // ���� upper(E[] data, E target,int l,int r)������mid
        return upper(data,target,l,r);

    }
    public static <E extends Comparable<E>> int upper(E[] data, E target,int l,int r) {
        if(l >= r) return r;
        // ���� �е� mid
        int mid = (r - l) / 2 + l;
        // ��midС��target,������mid �� mid+1 ��Ϊ l ���� upper
        if (data[mid].compareTo(target) <= 0) return upper(data, target, mid+1, r);
        // ��mid����target,�� mid ��Ϊ r ����upper
        else return upper(data, target, l, mid);
    }

    public static <E extends Comparable<E>> int searchR(E[] arr, E target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) return mid;
            if(arr[mid].compareTo(target) > 0) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer data[] = {10,23,45,61,78,88,90,100};
        int index = lower(data,60);
        System.out.println(index);
    }

}