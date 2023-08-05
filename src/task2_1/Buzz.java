package task2_1;

import java.util.concurrent.BlockingQueue;

public class Buzz extends Thread {


        public BlockingQueue<Integer> numberQueue;
        public BlockingQueue<String> resultQueue;

        Buzz(BlockingQueue<Integer> numberQueue, BlockingQueue<String> resultQueue) {
            this.numberQueue = numberQueue;
            this.resultQueue = resultQueue;
        }

        public void run() {
            try {
                int number;
                while ((number = numberQueue.take()) != 16) {
                    if (number % 5 == 0) {
                        resultQueue.put("buzz");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

