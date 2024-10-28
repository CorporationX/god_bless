package school.faang.task426.substation;

import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.merge(substationId, averageData, (oldValue, newValue) -> newValue);
    }

    public void printAll() {
        substationData.forEach((integer, aDouble) -> System.out.println(integer + " " + aDouble));
    }
}
