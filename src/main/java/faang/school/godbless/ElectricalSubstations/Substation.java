package faang.school.godbless.ElectricalSubstations;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Substation {
    private int id;
    private MonitoringSystem monitoringSystem;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap;
    private final ReentrantLock lock = new ReentrantLock();

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
        this.sensorDataMap = new ConcurrentHashMap<>();
    }

    public void receiveData(int sensorId, double data) {
        lock.lock();
        try {
            SensorData sensorData = sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData());
            sensorData.addData(data);
        } finally {
            lock.unlock();
        }
    }

    public void startCalculatingAverage() {
        lock.lock();
        try {
            monitoringSystem.updateData(id, sensorDataMap.values()
                    .stream()
                    .mapToDouble(SensorData::average)
                    .average()
                    .getAsDouble());
        } finally {
            lock.unlock();
        }
    }
}
