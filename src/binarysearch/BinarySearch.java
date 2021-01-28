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

    public static <E extends Comparable<E>> int search(E[] arr, E target) {
        return search(arr, target, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> int search(E[] arr, E target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = (r - l) / 2 + l;
        if (arr[mid].compareTo(target) == 0)
            return mid;
        if (arr[mid].compareTo(target) < 0)
            return search(arr, target, mid + 1, r);
        return search(arr, target, l, mid - 1);
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
}