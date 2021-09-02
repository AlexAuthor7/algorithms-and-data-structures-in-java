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
     * 没有 target,返回最小值索引
     * 有target,返回最大索引
     *
     */

    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data,target);
        if(data[u-1].compareTo(target) == 0) return u-1;
        else return u;
    }
    /**
     * @Description lower_floor
     * 有 target ，返回最小索引
     * 没有 targert , 返回 lower
     */
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        // 注意，因为我们要访问 data[l + 1]，所以，我们要先确保 l + 1 不越界，
        // 即 l + 1 < data.length
        if(l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    /**
     * @Description upper_floor
     * 有 target ，返回最大索引
     * 没有 targert , 返回 upper
     */
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
        int l = -1,r = data.length - 1;
        return upper_floor(data,target,l,r);
    }
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target,int l,int r) {
        if(l >= r) return l;
        // 为防止计算机整形计算 ，导致l和r相邻时，搜索范围不改变
        // 我们让计算机进行 mid 的计算时， 取右
        // 边界
        int mid = mid = l + (r -l + 1) / 2;
        if (data[mid].compareTo(target) <= 0) return upper(data, target, mid - 1, r);
        else return upper(data, target, l, mid - 1);
    }
    /**
     * @Description lower
     * 查找小于 target 的最大值
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1,r = data.length - 1;
        return lower(data,target,l,r);
    }
    public static <E extends Comparable<E>> int lower(E[] data, E target,int l,int r) {
        if(l >= r) return l;
        // 为防止计算机整形计算 ，导致l和r相邻时，搜索范围不改变
        // 我们让计算机进行 mid 的计算时， 取右
        // 边界
        int mid = mid = l + (r -l + 1) / 2;
        if (data[mid].compareTo(target) >= 0) return upper(data, target, l, mid-1);
        else return upper(data, target, mid, r);
    }


    /**
     * @Description lower——ceil
     * 寻找 大于等于 target 的最小索引
     */
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0,r = data.length;
        return lower_ceil(data,target,l,r);
    }
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target, int l, int r) {
        if(l >= r) return r;
        int mid = (r - l) / 2 + l;
        // mid 大于等于 target 时，让 mid 作为 r 传入 lweor_ceil
        if (data[mid].compareTo(target) >= 0) return lower_ceil(data,target,l,mid);
        // mid 小于等于 target 时，将 mid 丢弃， 将 mid+1 作为 l 传入
        else return lower_ceil(data,target,mid+1,r);
    }

    /**
     * @Description 基本的二分查找
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
     * @Description lower——ceil
     * 寻找大于 target 的最小索引
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0,r = data.length;
        // 再 data[l,r]中寻找解
        // 调用 upper(E[] data, E target,int l,int r)，返回mid
        return upper(data,target,l,r);

    }
    public static <E extends Comparable<E>> int upper(E[] data, E target,int l,int r) {
        if(l >= r) return r;
        // 定义 中点 mid
        int mid = (r - l) / 2 + l;
        // 若mid小于target,丢弃，mid 将 mid+1 作为 l 传入 upper
        if (data[mid].compareTo(target) <= 0) return upper(data, target, mid+1, r);
        // 若mid大于target,将 mid 作为 r 传入upper
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