package school.faang.bjs2_93246;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SubstationData {
    private final Substation substation;
    private final MonitoringSystem monitoringSystem;
    private final ScheduledExecutorService scheduler;

    public SubstationData(Substation substation, MonitoringSystem monitoringSystem) {
        this.substation = substation;
        this.monitoringSystem = monitoringSystem;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startCalculatingAverages() {
        Runnable task = () -> {
            double average = calculateOverallAverage();
            monitoringSystem.updateData(substation.getId(), average);
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

    public double calculateOverallAverage() {
        double totalSum = 0;
        long totalCount = 0;
        for (SensorData sensorData : substation.getSensorDataMap().values()) {
            totalSum += sensorData.getSum();
            totalCount += sensorData.getCount();
        }
        return totalCount == 0 ? 0 : totalSum / totalCount;
    }
}
