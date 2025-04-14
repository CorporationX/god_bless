package school.faang.bjs251184;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Substation {

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public Substation(int id, MonitoringSystem monitoringSystem) {
        if (id <= 0 || monitoringSystem == null) {
            log.error("Invalid input in Substation constructor");
            throw new IllegalArgumentException("Invalid input in Substation constructor");
        }
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {

        if (id <= 0 || data < 0) {
            log.error("Invalid input in receiveData");
            throw new IllegalArgumentException("Invalid input in receiveData");
        }
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
        log.info("Data received: {} for sensor {}", data, sensorId);
    }

    public void startCalculatingAverage() {
        log.info("Substation {} started calculating average", id);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            sensorDataMap.values().stream()
                    .map(SensorData::getAverage)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .ifPresent(average -> monitoringSystem.updateData(id, average));
        }, 0, 10, TimeUnit.SECONDS);
    }
}