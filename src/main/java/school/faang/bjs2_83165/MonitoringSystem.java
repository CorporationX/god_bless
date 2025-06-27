package school.faang.bjs2_83165;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("MonitoringSystem: Substation {} average = {}", substationId, String.format("%.2f", averageData));
    }

    public Double getAverageForSubstation(int substationId) {
        return substationData.get(substationId);
    }

    public ConcurrentHashMap<Integer, Double> getAllData() {
        return substationData;
    }
}
