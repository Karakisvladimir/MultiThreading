package task2_1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Number extends Thread {

    public BlockingQueue<Integer> numberQueue;
    public BlockingQueue<String> resultQueue;

    Number(BlockingQueue<Integer> numberQueue, BlockingQueue<String> resultQueue) {
        this.numberQueue = numberQueue;
        this.resultQueue = resultQueue;
    }

    public void run() {
        try {
            while (true) {
                int number = numberQueue.take();
                String result = resultQueue.poll();
                if (result == null) {
                    System.out.println(number);
                } else {
                    System.out.println(result);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

