package task2_1;

import java.util.concurrent.BlockingQueue;

public class FizzBuzz extends Thread {

        public BlockingQueue<Integer> numberQueue;
        public BlockingQueue<String> resultQueue;

        FizzBuzz(BlockingQueue<Integer> numberQueue, BlockingQueue<String> resultQueue) {
            this.numberQueue = numberQueue;
            this.resultQueue = resultQueue;
        }

        public void run() {
            try {
                int number;
                while ((number = numberQueue.take()) != 16) {
                    if (number % 3 == 0 && number % 5 == 0) {
                        resultQueue.put("fizzbuzz");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
