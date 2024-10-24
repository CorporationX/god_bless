package school.faang.monitorElectrostations;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Substation {
    private static final int NUM_THREADS = 10;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_THREADS);

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        executorService.scheduleAtFixedRate(() -> {
            for (int sensorId : sensorDataMap.keySet()) {
                SensorData sensorData = sensorDataMap.get(sensorId);
                if (sensorData.getCount() > 0) {
                    monitoringSystem.findData(id);
                    double average = sensorData.getAverage();
                    monitoringSystem.updateData(id, average);
                    System.out.println("Updated average for substation " + id + " to " + average);
                }
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

    public void stopCalculatingAverages() {
        executorService.shutdown();
    }
}
