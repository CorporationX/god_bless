package school.faang.task_51442;

import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.println("Updated data for substation " + substationId + ": " + averageData);
    }
}

