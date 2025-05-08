package school.faang.bjs251184;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {

    private ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        if (substationId <= 0 || averageData < 0) {
            log.error("Invalid input in updateData");
            throw new IllegalArgumentException("Invalid input in updateData");
        }
        substationData.put(substationId, averageData);
        log.info("Substation {} average data updated to {}", substationId, averageData);
    }


}
