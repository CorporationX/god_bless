package school.faang.bjs2_93246;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class SensorData {
    private final DoubleAdder sum = new DoubleAdder();
    private final LongAdder count = new LongAdder();

    public void addData(double data) {
        sum.add(data);
        count.increment();
    }

    public double getAverage() {
        long currentCount = count.sum();
        return currentCount == 0 ? 0 : sum.sum() / currentCount;
    }

    public double getSum() {
        return sum.sum();
    }

    public long getCount() {
        return count.sum();
    }
}
