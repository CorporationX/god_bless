package school.faang.bjs2_93246;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
    }

    public void printAllData() {
        substationData.forEach((substationId, average) ->
                System.out.printf("Substation %d: %.2f%n", substationId, average)
        );
    }

    public double getOverallAverage() {
        return substationData.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}
