package faang.school.godbless.ElectricalSubstations;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class MonitoringSystem {
    private ConcurrentHashMap<Integer, Double> substationData;
    private final ReentrantLock lock = new ReentrantLock();

    public MonitoringSystem() {
        this.substationData = new ConcurrentHashMap<>();
    }

    public void updateData(int substationId, double data) {
        lock.lock();
        try {
            substationData.computeIfPresent(substationId, (k, v) -> (v + data) / 2);
            substationData.put(substationId, data);
            System.out.println(Thread.currentThread().getId() + " | Substation " + substationId + " data: " + data);
        } finally {
            lock.unlock();
        }
    }
}
