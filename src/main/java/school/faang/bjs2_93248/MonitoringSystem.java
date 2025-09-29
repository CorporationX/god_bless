package school.faang.bjs2_93248;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("MonitoringSystem: Подстанция {}, среднее значение {}", substationId, averageData);
    }
}
