package school.faang.sprint_4.task_51154;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
@ToString
public class Substation {
    private static final int CALCULATION_DELAY = 5;
    private static final int AWAIT_DELAY = 5;

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final Map<Integer, SensorData> sensors = new ConcurrentHashMap<>();
    @ToString.Exclude
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void receiveData(int sensorId, double data) {
        sensors.computeIfAbsent(sensorId, (k) -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        executor.scheduleAtFixedRate(() -> monitoringSystem.updateData(id, getAverageData()),
                0,
                CALCULATION_DELAY,
                TimeUnit.SECONDS);
    }

    public void stopCalculatingAverages() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_DELAY, TimeUnit.SECONDS)) {
                log.info("Await timed out. Shutting down executor {}", executor);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread interrupted. Shutting down executor {}", executor);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private double getAverageData() {
        return sensors.values()
                .stream()
                .mapToDouble(SensorData::getAverage)
                .average()
                .orElse(0);
    }
}
