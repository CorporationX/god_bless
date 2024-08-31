package faang.school.godbless.substationsmonitoring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {
    private final int id;
    private final MonitoringSystem system;
    private final Map<Integer, SensorData> sensorDataMap;
    private final ScheduledExecutorService scheduler;

    public Substation(int id, MonitoringSystem system) {
        this.id = id;
        this.system = system;
        this.sensorDataMap = new ConcurrentHashMap<>();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(() -> {
            double totalSum = 0;
            double totalCount = 0;
            for (SensorData sensorData : sensorDataMap.values()) {
                totalSum += sensorData.getSum();
                totalCount += sensorData.getCount();
                sensorData.reset();
            }
            double average = totalCount > 0 ? totalSum / totalCount : 0;
            system.updateData(id, average);
        }, 1, 1, TimeUnit.MINUTES);
    }
}