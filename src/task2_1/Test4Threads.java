package task2_1;

public class Test4Threads {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        Thread threadA = new Thread(() -> {
            try {
                fb.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fb.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                fb.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                fb.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}

