package task1;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(() -> {
            long lastLoopTime = System.currentTimeMillis();
            while (true) {
                try {
                    Thread.sleep(1000);
                    long currentTime = System.currentTimeMillis();
                    System.out.println("Time passed: " + (currentTime - lastLoopTime) + " milliseconds");
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        Thread secondThread = new Thread(() -> {
            while (true) {
                System.out.println("Passed 5 seconds");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        firstThread.start();
        secondThread.start();
        firstThread.join(); // Очікуємо завершення першого потоку
        secondThread.join(); // Очікуємо завершення другого потоку

    }

}