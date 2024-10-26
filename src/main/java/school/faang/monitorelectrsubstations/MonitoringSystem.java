package school.faang.monitorelectrsubstations;

import lombok.Getter;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.println("Substation " + substationId + " average: " + averageData);
    }
}


