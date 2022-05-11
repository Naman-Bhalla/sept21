package threadforloop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThreads = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            allThreads.add(t);
            t.start();

            // Create object of a class that implements Runnable
            // Create an object of Thread and pass the oobj of runnable to constructor
            // start the thread
        }

        for (int i = 0; i < 100; ++i) {
            allThreads.get(i).join();
        }

        System.out.println("All the numbers of printed");
    }
}

// If you want to run a particular class within a thread
// Make that class implement Runnable
// override the run method of the class()

// Assignment
// Program which runs a loop from 1 to 100
// for every number it creates a separate thread to print that number