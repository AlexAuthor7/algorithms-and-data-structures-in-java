package Test;

/**
 * @Auther: Alex
 * @Date: 2021/3/10 - 03 - 10 -22:00
 * @Description: Test
 * @Verxion: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            if(m.isHappy(i)) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);
    }
    // �ж�һ�����Ƿ��ǿ�����
    public boolean isHappy(int n) {
        int p = n,q = n;
        do {
            p = getNext(p);
            q = getNext(getNext(q));
        } while(p != q && q != 1);
        return q == 1;
    }
    // ��ȡ��һλ��
    public int getNext(int n) {
        int sum = 0;
        while(n != 0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}
