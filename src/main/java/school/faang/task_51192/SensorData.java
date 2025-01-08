package school.faang.task_51192;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class SensorData {
    private final AtomicReference<Double> sum = new AtomicReference<>(0.0);
    private final AtomicInteger count = new AtomicInteger(0);

    public void addData(double data) {
        sum.updateAndGet(result -> sum.get() + data);
        count.getAndIncrement();
    }

    public double getAverage() {
        if (count.get() > 0) {
            return sum.get() / count.get();
        } else {
            return 0.0;
        }
    }
}
