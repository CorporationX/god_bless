package school.BJS2_39195;

import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {

    private ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.println("Подстанция " + substationId + ": среднее значение = " + averageData);
    }
}

