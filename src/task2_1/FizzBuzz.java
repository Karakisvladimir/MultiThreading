package task2_1;

import java.util.concurrent.Semaphore;

class FizzBuzz {

    private int n;

    Semaphore fizzSemaphore = new Semaphore(0);
    Semaphore buzzSemaphore = new Semaphore(0);
    Semaphore fizzBuzzSemaphore = new Semaphore(0);
    Semaphore responseSemaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSemaphore.acquire();
                System.out.print("fizz, ");
                responseSemaphore.release();
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSemaphore.acquire();
                System.out.print("buzz, ");
                responseSemaphore.release();
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzBuzzSemaphore.acquire();
            System.out.print("fizzbuzz, ");
            responseSemaphore.release();
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            responseSemaphore.acquire();
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    fizzBuzzSemaphore.release();
                } else {
                    fizzSemaphore.release();
                }
            } else if (i % 5 == 0) {
                buzzSemaphore.release();
            } else {
                System.out.print(i + ", ");
                responseSemaphore.release();
            }
        }


    }
}
