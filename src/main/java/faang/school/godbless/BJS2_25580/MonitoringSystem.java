package faang.school.godbless.BJS2_25580;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MonitoringSystem {
    private Map<Integer, ConcurrentLinkedQueue<SensorData>> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, SensorData averageData) {
        substationData.computeIfAbsent(substationId, key -> new ConcurrentLinkedQueue<>()).add(averageData);
        System.out.println(substationId + " has new average data: " + averageData);
    }
}
