package derschrank.sprint04.task20.bjstwo_51174;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

public class SensorData {
    private final AtomicInteger count = new AtomicInteger(0);
    private final DoubleAdder sum = new DoubleAdder();

    public synchronized void addData(double data) {
        sum.add(data);
        count.incrementAndGet();
    }

    public synchronized double getAverage() {
        return count.get() == 0 ? 0 : sum.doubleValue() / count.get();
    }

    public double getSum() {
        return  sum.doubleValue();
    }

    public int getCount() {
        return count.get();
    }
}
