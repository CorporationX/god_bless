package school.faangSprint4.t21;

import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData;

    public MonitoringSystem() {
        this.substationData = new ConcurrentHashMap<>();
    }

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.printf("Substation %d: Average data = %.2f%n", substationId, averageData);
    }
}