package school.faang.bjs2_83165;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Getter
public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, key -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(() -> {
            double totalSum = 0;
            int totalCount = 0;

            for (SensorData data : sensorDataMap.values()) {
                totalSum += data.getSum();
                totalCount += (int) data.getCount();
            }

            double average = totalCount == 0 ? 0.0 : totalSum / totalCount;

            monitoringSystem.updateData(id, average);
        }, 0, 1, TimeUnit.MINUTES);
    }
}
