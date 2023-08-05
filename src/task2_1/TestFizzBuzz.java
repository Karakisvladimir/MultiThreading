package task2_1;
import java.util.concurrent.*;

public class TestFizzBuzz {
    private static BlockingQueue<Integer> numberQueue = new ArrayBlockingQueue<Integer>(20);
    private static BlockingQueue<String> resultQueue = new ArrayBlockingQueue<String>(20);

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Fizz(numberQueue, resultQueue));
        executorService.submit(new Buzz(numberQueue, resultQueue));
        executorService.submit(new FizzBuzz(numberQueue, resultQueue));
        executorService.submit(new Number(numberQueue, resultQueue));

        for (int i = 1; i <= 15; i++) {
            numberQueue.put(i);
        }

        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

}
