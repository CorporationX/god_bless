package faang.school.godbless.sprint4.electro;


import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int sensorId, double averageData) {
        substationData.put(sensorId, averageData);
    }

    public void showAverage() {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> {
            System.out.println("Average: " + substationData);
        };
        scheduled.scheduleAtFixedRate(task, 0L, 60000L, TimeUnit.MILLISECONDS);
    }
}
