package school.faang.monitorelectrsubstations;

import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData;

    public MonitoringSystem() {
        this.substationData = new ConcurrentHashMap<>();
    }

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.println("Substation " + substationId + " average: " + averageData);
    }
}

