package faang.school.godbless.substationsMonitoring;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {
    @Getter
    private int id;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);

    public Substation(int id) {
        this.id = id;
    }

    public void addSensor(Sensor sensor) {
        sensorDataMap.put(sensor.getId(), sensor.getSensorData());
    }

    public double calculateAverage() {
        double sum = 0;
        for (SensorData sensorData : sensorDataMap.values()) {
            sum += sensorData.getAverageData();
        }
        return sum / sensorDataMap.size();
    }

    public void startReceivingData() {
        executorService.scheduleAtFixedRate(() -> {
                for (SensorData sensorData : sensorDataMap.values()) {
                    sensorData.getSensor().startGeneratingData();
                }
            },0, 30, TimeUnit.SECONDS);
    }

    public void stopReceivingData() {
        for (SensorData sensorData : sensorDataMap.values()) {
            sensorData.getSensor().stopGeneratingData();
        }
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
