package school.faang.monitorElectrostations;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationDataMap = new ConcurrentHashMap<>();

    public void findData(int substationId) {
        System.out.println("Data for substation " + substationId + ": " + substationDataMap.get(substationId));
    }

    public void updateData(int substationId, double data) {
        substationDataMap.put(substationId, data);
    }
}
