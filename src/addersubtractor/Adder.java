package addersubtractor;

public class Adder implements Runnable {
    Counter counter;

    Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
////            this.counter.value += 1; // critical
//            int currentValue = this.counter.getValue();
//            int newValue = currentValue + 1;
//            this.counter.setValue(newValue);
            this.counter.addValue(1);
        }
    }
}
