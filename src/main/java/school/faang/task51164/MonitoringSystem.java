package school.faang.task51164;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void update(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("Обновленные даные у substation {} {}", substationId, averageData);
    }
}
