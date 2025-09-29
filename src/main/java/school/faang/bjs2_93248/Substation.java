package school.faang.bjs2_93248;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@AllArgsConstructor
public class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }
}
