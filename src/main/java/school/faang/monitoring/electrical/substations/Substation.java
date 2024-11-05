package school.faang.monitoring.electrical.substations;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Substation {
    private static final ScheduledExecutorService SCHEDULER =
            new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());

    @Getter
    private int id;

    private MonitoringSystem monitoringSystem;
    private final ConcurrentMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.merge(sensorId, new SensorData(data, 1), SensorData::merge);
    }

    public void startCalculatingAverages() {
        SCHEDULER.scheduleAtFixedRate(() -> {
            double avg = sensorDataMap.values().stream()
                    .map(SensorData::getAverage)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);
            System.out.println("считаем среднее для " + id + " " + avg);
            if (avg != 0) {
                monitoringSystem.updateData(id, avg);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public Sensor createSensor() {
        int newSensorId = Integer.parseInt("" + id + sensorDataMap.size());
        sensorDataMap.put(newSensorId, new SensorData(0, 0));
        return new Sensor(newSensorId, this);
    }

    public static void shutdown() {
        SCHEDULER.shutdown();
    }

    @Override
    public String toString() {
        return id + "";
    }
}
