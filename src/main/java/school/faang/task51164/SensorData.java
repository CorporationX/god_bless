package school.faang.task51164;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
public class SensorData {
    private final AtomicReference<Double> sum = new AtomicReference<>(0.0);
    private final AtomicInteger count = new AtomicInteger(0);

    public void addData(double data) {
        sum.updateAndGet(result -> sum.get() + data);
        count.incrementAndGet();
    }

    public double getAverage() {
        return sum.get() / count.get();
    }
}
