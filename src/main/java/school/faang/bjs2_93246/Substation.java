package school.faang.bjs2_93246;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Substation {
    @Getter
    private int id;
    private MonitoringSystem monitoringSystem;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap;
    private ScheduledExecutorService scheduler;

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
        this.sensorDataMap = new ConcurrentHashMap<>();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void receiveData(int sensorId, double data) {
        SensorData sensor = sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData());
        sensor.addData(data);
    }

    public void startCalculatingAverages() {
        Runnable task = () -> {
            double average = calculateOverallAverage();
            monitoringSystem.updateData(id, average);
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

    public double calculateOverallAverage() {
        double totalSum = 0;
        long totalCount = 0;
        for (SensorData sensorData : sensorDataMap.values()) {
            totalSum += sensorData.getSum();
            totalCount += sensorData.getCount();
        }
        return totalCount == 0 ? 0 : totalSum / totalCount;
    }
}
