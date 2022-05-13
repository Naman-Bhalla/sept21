package adderSubtractorLock;

import java.util.concurrent.Semaphore;

public class Subtractor implements Runnable {
    Counter counter;
    Semaphore semaphore;

    Subtractor(Counter counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
//            this.counter.value -= 1;
            try {
                semaphore.acquire();
                int currentValue = this.counter.getValue();
                int newValue = currentValue - 1;
                this.counter.setValue(newValue);
                semaphore.release();
            } catch (Exception e) {
                System.out.println("Issue acquirinfg lock");
            }

        }
    }
}
