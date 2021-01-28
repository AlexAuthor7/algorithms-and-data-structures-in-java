package qurue;

import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/6 - 01 - 06 -21:57
 * @Description: qurue
 * @Verxion: 1.0
 */
public class Main {
    //测试使用q 运行opCount 个 enqueue 和 的dequeue 操作所需要的时间，单位：秒
    private static double testQueue(qurue.Queue<Integer> q, int opCount){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        qurue.ArrayQueue<Integer> arrayQueue = new qurue.ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue,opCount);
        qurue.LoopQueue<Integer> loopQueue = new qurue.LoopQueue<Integer>();
        double time2 = testQueue(loopQueue,opCount);

        System.out.println("ArrayQueue, Time: " + time1 +" s");
        System.out.println("LoopQueue, Time: " + time2 +" s");

    }
}
