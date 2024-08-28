package faang.school.godbless.substationsMonitoring;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sensor {
    @Getter
    private final int id;
    @Getter
    private final Substation substation;
    @Getter
    private final SensorData sensorData;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        this.sensorData = new SensorData(this);
        substation.addSensor(this);
    }

    public void startGeneratingData() {
        executorService.scheduleAtFixedRate(
                () -> sensorData.addData(new Random().nextDouble(100)),
                0, 1, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
