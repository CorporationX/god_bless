package school.faang.electricalsubstations;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int COUNT_SUBSTATIONS = 10;
    private static final int COUNT_SENSORS = 100;
    private static final int TIME_TO_WORK = 10_000;
    private static final int MAX_TIME_TO_WORK = 10;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        MonitoringSystem system = new MonitoringSystem();
        List<Substation> substations = new ArrayList<>();
        List<Sensor> sensors = new ArrayList<>();

        for (int i = 0; i < COUNT_SUBSTATIONS; i++) {
            substations.add(new Substation(i, system));

            for (int j = 0; j < COUNT_SENSORS; j++) {
                sensors.add(new Sensor(j, substations.get(i)));
            }
        }

        sensors.forEach(sensor ->
                executor.scheduleWithFixedDelay(sensor::startGeneratingData,
                        0, 1, TimeUnit.SECONDS));

        substations.forEach(substation ->
                executor.scheduleWithFixedDelay(substation::startCalculatingAverages,
                        0, 1, TimeUnit.SECONDS));

        try {
            Thread.sleep(TIME_TO_WORK);
        } catch (InterruptedException e) {
            log.error("Поток был прерван " + e.getMessage());
        }

        executor.shutdown();

        try {
            if(executor.awaitTermination(MAX_TIME_TO_WORK, TimeUnit.SECONDS)) {
                log.info("Программа завершена");
            } else {
                log.warn("Программа завершена принудительно");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван " + e.getMessage());
        }
    }
}