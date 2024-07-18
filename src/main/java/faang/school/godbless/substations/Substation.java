package faang.school.godbless.substations;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Substation {
    private final int TIME_INTERVAL = 60;

    private int id;
    private MonitoringSystem monitoringSystem;
    private ScheduledExecutorService executorService;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, sensorIdAsKey -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        executorService.scheduleAtFixedRate(() -> {
            Double totalDataSum = sensorDataMap.values().stream()
                    .map(SensorData::getAverageData)
                    .reduce(0.0, Double::sum);
            monitoringSystem.updateData(id, totalDataSum);
        }, TIME_INTERVAL, TIME_INTERVAL, TimeUnit.SECONDS);
    }

    public void closeSubstation() {
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
