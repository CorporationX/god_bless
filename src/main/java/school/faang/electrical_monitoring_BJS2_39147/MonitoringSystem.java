package school.faang.electrical_monitoring_BJS2_39147;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class MonitoringSystem {
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.printf("Substation id: %d, average value of all sensors: %.2f\n",
                substationId, substationData.get(substationId));
    }
}