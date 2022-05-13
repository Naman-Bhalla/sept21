package adderSubtractorLock;

import java.util.concurrent.Semaphore;

public class Adder implements Runnable {
    Counter counter;
    Semaphore semaphore;

    Adder(Counter counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
////            this.counter.value += 1; // critical
            try {
                semaphore.acquire();
                int currentValue = this.counter.getValue();
                int newValue = currentValue + 1;
                this.counter.setValue(newValue);
                semaphore.release();
            } catch (Exception e) {
                System.out.println("Issue acquiring lock");
            }
        }
    }
}
