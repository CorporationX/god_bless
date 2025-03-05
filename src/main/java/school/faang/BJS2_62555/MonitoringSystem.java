package school.faang.BJS2_62555;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private static final String LOG_STRING = "Substation id {} updated, data: {}";
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.compute(substationId, (key, v) -> averageData);
        log.info(LOG_STRING, substationId, String.format("%.2f", averageData));
    }

    public void printAllData() {
        substationData.forEach((id, value) ->
                log.info(LOG_STRING, id, String.format("%.2f", value)));
    }
}
