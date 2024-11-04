package school.faangSprint4.t21;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class SensorData {
    private final AtomicReference<Double> sum;
    private final AtomicLong count;

    public SensorData() {
        this.sum = new AtomicReference<>(0.0);
        this.count = new AtomicLong(0);
    }

    public void addData(double data) {
        sum.updateAndGet(currentSum -> currentSum + data);
        count.incrementAndGet();
    }

    public double getAverage() {
        long currentCount = count.get();
        return currentCount > 0 ? sum.get() / currentCount : 0.0;
    }

    public void reset() {
        sum.set(0.0);
        count.set(0);
    }
}