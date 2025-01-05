package derschrank.sprint04.task20.bjstwo_51174;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation implements SubstationInterface {
    private static final int PERIOD_OF_CALCULATING_SEC = 60;

    private final ScheduledExecutorService executor;
    private final int id;
    private final MonitoringSystem monitoring;
    private final Map<Integer, SensorData> sensorDataMap;

    public Substation(int id, MonitoringSystem monitoring) {
        this.id = id;
        this.monitoring = monitoring;
        sensorDataMap = new ConcurrentHashMap<>();
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    @Override
    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(
                () -> calculatingAverage(),
            0,
                PERIOD_OF_CALCULATING_SEC,
                TimeUnit.MILLISECONDS);
    }

    @Override
    public void stopCalculatingAverages() {
        executor.shutdown();
    }

    public void calculatingAverage() {
        double totalSum = 0.0;
        int totalCount = 0;
        for (SensorData data : sensorDataMap.values()) {
            synchronized (data) {
                totalSum += data.getSum();
                totalCount += data.getCount();
            }
        }

        if (totalCount > 0) {
            monitoring.updateData(id, totalSum / totalCount);
        }
    }
}
