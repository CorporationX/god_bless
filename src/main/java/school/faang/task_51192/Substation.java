package school.faang.task_51192;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class Substation {
    private static final long TIMEOUT = 2;
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 1;
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, key -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(
                () -> {
                    double average = sensorDataMap.values().stream()
                            .collect(Collectors.averagingDouble(SensorData::getAverage));
                    monitoringSystem.updateData(id, average);
                },
                INITIAL_DELAY,
                PERIOD,
                TimeUnit.MINUTES
        );
        scheduler.schedule(scheduler::shutdown, TIMEOUT, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
