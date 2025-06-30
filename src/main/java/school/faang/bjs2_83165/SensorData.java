package school.faang.bjs2_83165;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAdder;

public class SensorData {
    private final DoubleAdder sum = new DoubleAdder();
    private final AtomicLong count = new AtomicLong();

    public void addData(double data) {
        sum.add(data);
        count.incrementAndGet();
    }

    public double getAverage() {
        long currentCount = count.get();
        return currentCount == 0 ? 0.0 : sum.sum() / currentCount;
    }

    public double getSum() {
        return sum.sum();
    }

    public long getCount() {
        return count.get();
    }
}
