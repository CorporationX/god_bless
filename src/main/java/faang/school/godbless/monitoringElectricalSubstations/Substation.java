package faang.school.godbless.monitoringElectricalSubstations;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap;

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
        this.sensorDataMap = new ConcurrentHashMap<>();
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages(ScheduledExecutorService executor) {
        executor.scheduleAtFixedRate(() -> {
            double averageData = calculateAverageData();
            monitoringSystem.updateData(id, averageData);
        }, 0, 1, TimeUnit.MINUTES);
    }

    private double calculateAverageData() {
        double sum = 0;
        int count = 0;

        for (SensorData sensorData : sensorDataMap.values()) {
            sum += sensorData.getSum();
            count += sensorData.getCount();
        }

        return count > 0 ? sum / count : 0;
    }
}
