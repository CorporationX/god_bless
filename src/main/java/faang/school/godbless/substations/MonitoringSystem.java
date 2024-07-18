package faang.school.godbless.substations;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        String message = String
                .format("Substation with id: %s has %f", substationId, substationData.get(substationId));
        System.out.println(message);
    }
}
