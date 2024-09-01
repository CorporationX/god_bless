package faang.school.godbless.substationsMonitoring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitoringSystem {
    private final Map<Substation, Double> substationData = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);

    public void addSubstation(Substation substation) {
        substationData.put(substation, 0.0);
    }

    public void updateData(Substation substation, double averageData) {
        substationData.put(substation, averageData);
    }

    public void startReporting() {
        System.out.println("REPORT: ");
        executorService.scheduleAtFixedRate(() -> {
            for (Substation substation : substationData.keySet()) {
                updateData(substation, substation.calculateAverage());
            }
            substationData.forEach((key, value) -> System.out.println("Substation " + key.getId() + ": " + value));
        }, 1, 1, TimeUnit.MINUTES);
    }

    public void stopReporting() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
