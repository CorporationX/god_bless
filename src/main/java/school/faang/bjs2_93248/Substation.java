package school.faang.bjs2_93248;

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
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(() -> {
            double averageAllSensors = sensorDataMap.values().stream()
                    .mapToDouble(SensorData::getAverage)
                    .filter(avg -> avg > 0)
                    .average()
                    .orElse(0.0);
            monitoringSystem.updateData(id, averageAllSensors);
        }, 60, 60, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(3, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}