package addersubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // counter
        // 2 parallel tasks
        // - 1 adds 1 to 100 in the counter
        // - 2 subtracts 1 to 100 from the counter
        // expected final value = 0

        Counter counter = new Counter();
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> adderReturn = executorService
                .submit(adder);
        Future<?> subReturn = executorService
                .submit(subtractor);

        try {
            adderReturn.get();
            subReturn.get();
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something is wrong");
        }

        System.out.println(counter.getValue());
    }
}
