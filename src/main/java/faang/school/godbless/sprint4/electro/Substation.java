package faang.school.godbless.sprint4.electro;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Substation {
    private int id;
    private MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, Double> sensorData = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorData.put(sensorId, data);
    }

    public void startCalculatingAverages() {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> {
            double average = 0;
            int i;
            for (i = 0; i < sensorData.size(); ++i) {
                average += sensorData.getOrDefault(i, (double) 0);
            }
            average /= sensorData.size();
            monitoringSystem.updateData(this.id, average);
        };
        scheduled.scheduleAtFixedRate(task, 0L, 60000L, TimeUnit.MILLISECONDS);

    }
}
