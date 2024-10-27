package school.faang.monitoring.electrical.substations;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MonitoringSystem {
    private final ConcurrentMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        substationData.forEach((k, v) -> System.out.println("Substation " + k + " : " + v));
    }
}
