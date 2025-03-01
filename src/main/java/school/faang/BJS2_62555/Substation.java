package school.faang.BJS2_62555;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Substation {
    private static final long SEND_PERIOD_SEC = 5;
    private static final int POOL_SIZE = 1;
    private static final int INITIAL_TASK_DELAY = 0;

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);

    public void receiveData(int sensorId, double data) {
        sensorDataMap.compute(sensorId, (k, v) -> {
            if (v == null) {
                v = new SensorData();
            }
            v.addData(data);
            return v;
        });
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> {
            double averageData = sensorDataMap.values().stream()
                    .mapToDouble(SensorData::getAverage)
                    .average()
                    .orElse(0.0);
            synchronized (monitoringSystem) {
                monitoringSystem.updateData(id, averageData);
            }
        }, INITIAL_TASK_DELAY, SEND_PERIOD_SEC, TimeUnit.SECONDS);
    }

    public void stopCalculatingAverages() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
