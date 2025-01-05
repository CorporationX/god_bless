package derschrank.sprint04.task20.bjstwo_51174;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final Map<Integer, Double> substatinData;

    public MonitoringSystem() {
        substatinData = new ConcurrentHashMap<>();
    }

    public void updateData(int substationId, double averageData) {
        substatinData.put(substationId, averageData);
        System.out.printf("Substation: %d, average amount: %f%n", substationId, averageData);
    }
}
