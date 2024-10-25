package school.faang.electricalsubstations;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Substation {
    private int id;
    private MonitoringSystem monitoringSystem;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, key -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        double averageData = sensorDataMap.values().stream()
                .map(SensorData::getAverage)
                .collect(Collectors.averagingDouble(Double::doubleValue));
        monitoringSystem.updateData(id, averageData);
    }
}