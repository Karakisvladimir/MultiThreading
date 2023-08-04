package task2;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestMultiThread {
    public static void main(String[] args) {
        int n = 15;

        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
        Thread tA = new Thread(new Fizz(1, q, n));
        Thread tB = new Thread(new Buzz(2, q, n));
        Thread tC = new Thread(new FizzBuzz(3, q, n));
        Thread tD = new Thread(new Number(4, q, n));
        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
    }

