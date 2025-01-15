package school.faang.task_51442;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            double totalSum = 0;
            int totalCount = 0;
            for (SensorData sensorData : sensorDataMap.values()) {
                totalSum += sensorData.getSum();
                totalCount += sensorData.getCount();
            }
            double average = totalCount > 0 ? totalSum / totalCount : 0;
            monitoringSystem.updateData(id, average);
        }, 0, 1, TimeUnit.MINUTES);
    }
}
