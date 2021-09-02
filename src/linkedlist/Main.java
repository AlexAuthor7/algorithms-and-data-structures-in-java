package linkedlist;

import queue.ArrayQueue;
import queue.Queue;


import java.util.Random;

/**
 * @Auther: Alex
 * @Date: 2021/1/9 - 01 - 09 -14:58
 * @Description: linkedlist
 * @Verxion: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time1 = testStack(arrayQueue,opCount);
        double time2 = testStack(linkedListQueue,opCount);
        System.out.println( "ArrayeQueue:" + time1 +"\n"
                + "LinkedListQueue:"+time2
        );
    }



    public static double testStack(Queue<Integer> stack, int opCount){
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            stack.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.dequeue();
        }

        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }
}
