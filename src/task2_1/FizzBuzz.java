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

//    acquire() -это метод Semaphore, который запрашивает доступ или захватывает разрешение экземпляра семафора.
//    Это метод блокирует вызывающий поток до тех пор, пока семафор не будет иметь доступное разрешение.
//    Если доступных разрешений нет, то вызывающий поток блокируется до тех пор,
//    пока другой поток не освободит разрешение.
    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSemaphore.acquire();
                System.out.print("fizz, ");
                responseSemaphore.release();
            }
        }
    }
//release() - это метод Semaphore, который освобождает разрешение экземпляра семафора.
// Это освобождает доступ к ресурсу для других потоков, которые могут теперь взять это освобожденное разрешение.
    public void buzz() throws InterruptedException {
        for (int i = 1; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSemaphore.acquire();
                System.out.print("buzz, ");
                responseSemaphore.release();
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 1; i <= n; i += 15) {
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
