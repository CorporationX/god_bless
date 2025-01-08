package school.faang.task_51192;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        log.info("Среднее значение на станции {} обновлено  : {}", substationId, averageData);
    }
}
