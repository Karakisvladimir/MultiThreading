package task2;

import java.util.concurrent.ConcurrentLinkedQueue;

public  class Buzz implements Runnable {
    private int number;
    private ConcurrentLinkedQueue<String> q;
    private int n;

    public Buzz(int number, ConcurrentLinkedQueue<String> q, int n) {
        this.number = number;
        this.q = q;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                q.add("Buzz");
            }

        }
    }
}
