package school.faang.task51164;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Substation {
    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private static final int TIME_TO_SHUTDOWN = 2;

    private final MonitoringSystem monitoringSystem;
    @ToString.Include
    private final int id;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        SensorData sensorData = sensorDataMap.computeIfAbsent(sensorId, id -> new SensorData());

        sensorData.addData(data);

        log.info("{} получил данные {}", this, sensorData);
    }

    private CompletableFuture<Double> average() {
        return CompletableFuture.supplyAsync(() -> sensorDataMap.values().stream()
                .mapToDouble(data -> {
                    double averageData = data.getAverage();
                    data.getSum().getAndSet(0.0);
                    data.getCount().getAndSet(0);

                    return averageData;
                })
                .average()
                .orElse(0.0));
    }

    public void startCalculatingAverages() {

        service.scheduleAtFixedRate(() -> monitoringSystem
                .update(id, average().join()), 0, 1, TimeUnit.MINUTES);
    }

    public void stopGeneration() {
        service.shutdown();
        try {
            service.awaitTermination(TIME_TO_SHUTDOWN, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Произошла ошибка в расчёте среднего значения", e);
        }
    }
}