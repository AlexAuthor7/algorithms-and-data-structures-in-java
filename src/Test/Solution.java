package Test;

import linearSearch.SortingHelper;

import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/11 - 01 - 11 -15:55
 * @Description: Test
 * @Verxion: 1.0
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums,0,nums.length-1,nums.length-k,random);
    }
    private int selectK(int[] arr,int l,int r,int k,Random random){

        while(l <= r){
            int p = partition(arr,l,r,random);
            if(k == p) return arr[p];
            if(k < p) r = p - 1;
            else l = p + 1;
        }
        throw new RuntimeException("No Solution");
    }
    private int partition(int[] arr,int l,int r,Random random){
        int p = random.nextInt(r-l+1) + l;
        swap(arr,l,p);
        int i = l + 1,j = r;
        while(true){
            while(i <= j && arr[i] < arr[l]) i++;
            while(j >= i && arr[j] > arr[l]) j--;

            if(i >= j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,j,l);
        return j;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        Solution s = new Solution();
        int res = s.findKthLargest(arr,2);
        System.out.println(res);
    }
}