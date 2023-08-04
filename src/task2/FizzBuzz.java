package task2;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FizzBuzz implements Runnable {
    private int number;
    private ConcurrentLinkedQueue<String> q;
    private int n;

    public FizzBuzz(int number, ConcurrentLinkedQueue<String> q, int n) {
        this.number = number;
        this.q = q;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                q.add("FizzBuzz");
            }
        }
    }
}
