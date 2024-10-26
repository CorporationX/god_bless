package school.faang.monitorelectrsubstations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class Substation {
    private final int id; // Уникальный идентификатор подстанции
    private final MonitoringSystem monitoringSystem; // Ссылка на систему мониторинга
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> {
            double totalSum = 0;
            int totalCount = 0;

            for (SensorData sensorData : sensorDataMap.values()) {
                totalSum += sensorData.getSum();
                totalCount += sensorData.getCount();
            }

            double average = totalCount == 0 ? 0 : totalSum / totalCount;
            monitoringSystem.updateData(id, average);
        }, 0, 60, TimeUnit.SECONDS);
    }

    public void stopCalculatingAverages() {
        executor.shutdown();
    }
}

