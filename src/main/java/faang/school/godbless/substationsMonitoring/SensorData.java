package faang.school.godbless.substationsMonitoring;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class SensorData {
    @Getter
    private final Sensor sensor;
    @Getter
    private double averageData = 0;
    private final AtomicInteger dataCount = new AtomicInteger(0);

    public SensorData(Sensor sensor) {
        this.sensor = sensor;
    }

    public synchronized void addData(double value) {
        averageData = (averageData * dataCount.intValue() + value) / (dataCount.intValue() + 1);
        dataCount.incrementAndGet();
    }
}
