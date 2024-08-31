package faang.school.godbless.substationsmonitoring;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final Map<Integer, Double> substationData;

    public MonitoringSystem() {
        this.substationData = new ConcurrentHashMap<>();
    }

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("Substation {} - Average Data: {}", substationId, averageData);
    }
}