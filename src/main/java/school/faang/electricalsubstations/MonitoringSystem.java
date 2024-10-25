package school.faang.electricalsubstations;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("Подстанция " + substationId + ": среднее значение - " + averageData);
    }
}
