package faang.school.godbless.substationsmonitoring;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

public class SensorData {
    private final DoubleAdder sum;
    private final AtomicInteger count;

    public SensorData() {
        this.sum = new DoubleAdder();
        this.count = new AtomicInteger();
    }

    public void addData(double data) {
        sum.add(data);
        count.incrementAndGet();
    }

    public double getSum() {
        return sum.doubleValue();
    }

    public long getCount() {
        return count.get();
    }

    public void reset() {
        sum.reset();
        count.set(0);
    }
}