package faang.school.godbless.BJS2_25580;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Substation {
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private Map<Integer, ConcurrentLinkedQueue<SensorData>> sensorDataMap = new ConcurrentHashMap<>();
    private double sumPower = 0.0;
    private double sumVoltage = 0.0;

    public void receiveData(int sensorId, SensorData data) {
        sensorDataMap.computeIfAbsent(sensorId, key -> new ConcurrentLinkedQueue<>()).add(data);
        sumPower += data.getPower();
        sumVoltage += data.getVoltage();
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Start calculating averages for " + id);

            int size = sensorDataMap.size();
            SensorData averageData = new SensorData(
                    sumPower / size,
                    sumVoltage / size
            );
            monitoringSystem.updateData(id, averageData);

        }, 0, 1, TimeUnit.MINUTES);
    }
}
