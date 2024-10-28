package school.faangSprint4.t21;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap;
    private final ScheduledExecutorService executor;

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
        this.sensorDataMap = new ConcurrentHashMap<>();
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> {
            double totalAverage = sensorDataMap.values().stream()
                    .mapToDouble(SensorData::getAverage)
                    .average()
                    .orElse(0.0);

            monitoringSystem.updateData(id, totalAverage);

             sensorDataMap.values().forEach(SensorData::reset);
        }, 1, 1, TimeUnit.MINUTES);
    }

    public void shutdown() {
        executor.shutdown();
    }
}