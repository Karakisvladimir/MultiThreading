package task2_1;

import java.util.concurrent.BlockingQueue;

public class Fizz extends Thread {


        public BlockingQueue<Integer> numberQueue;
        public BlockingQueue<String> resultQueue;

        Fizz(BlockingQueue<Integer> numberQueue, BlockingQueue<String> resultQueue) {
            this.numberQueue = numberQueue;
            this.resultQueue = resultQueue;
        }

        public void run() {
            try {
                int number;
                while ((number = numberQueue.take()) != 16) {
                    if (number % 3 == 0) {
                        resultQueue.put("fizz");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

