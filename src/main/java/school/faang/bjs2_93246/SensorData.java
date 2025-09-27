package school.faang.bjs2_93246;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class SensorData {
    private final DoubleAdder sum = new DoubleAdder();
    private final LongAdder count = new LongAdder();

    public void addData(double data) {
        sum.add(data);
        count.increment();
    }

    public double getSum() {
        return sum.sum();
    }

    public long getCount() {
        return count.sum();
    }

    public void startGeneratingData(Sensor sensor) {
        Runnable task = () -> {
            double data = Math.random() * 100;
            sensor.getSubstation().receiveData(sensor.getId(), data);
        };
        sensor.getScheduler().scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
