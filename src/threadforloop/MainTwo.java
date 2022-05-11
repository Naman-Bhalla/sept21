package threadforloop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTwo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; ++i) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);

            if (i == 30) {
                System.out.println("Wait");
            }

            // Create object of a class that implements Runnable
            // Create an object of Thread and pass the oobj of runnable to constructor
            // start the thread
        }
    }
}

// If you want to run a particular class within a thread
// Make that class implement Runnable
// override the run method of the class()

// Assignment
// Program which runs a loop from 1 to 100
// for every number it creates a separate thread to print that number