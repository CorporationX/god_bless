package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RequiredArgsConstructor
public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final ReentrantLock lock = new ReentrantLock();

    public void receiveData(int sensorId, double data) {
        lock.lock();
        try {
            sensorDataMap.putIfAbsent(sensorId, new SensorData(0, 0));
            sensorDataMap.get(sensorId).addData(data);
            log.info("Substation received {} from sensor with id {}", data, sensorId);
        } finally {
            lock.unlock();
        }
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> {
            double averageValue = sensorDataMap.values().stream()
                    .mapToDouble(SensorData::getAverage)
                    .average()
                    .orElse(0.0);
            monitoringSystem.updateData(id, averageValue);
        }, 1, 1, TimeUnit.MINUTES);
    }

    public void stopCalculatingAverages() {
        executor.shutdownNow();
    }
}
