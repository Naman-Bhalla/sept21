package threadforloop;

public class NumberPrinter implements Runnable {
    private  int number;

    NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (this.number == 50) {
            System.out.println("Wait");
        }
        System.out.println("The number is " + number);
    }
}
