package faang.school.godbless.substations;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 10;

    private static final int TIME_LIMIT_IN_SECONDS = 130;
    private static final long TIME_LIMIT_IN_MILLIS = 130000L;
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(THREAD_NUM);

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Substation> substationList = getSubstationList(monitoringSystem);
        List<Sensor> sensorList = substationList.stream()
                .flatMap(substation -> getSensorList(substation).stream())
                .toList();
        sensorList.forEach(Sensor::startGeneratingData);
        substationList.forEach(Substation::startCalculatingAverages);

        try {
            Thread.sleep(TIME_LIMIT_IN_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Main thread was interrupted during execution");
        }

        sensorList.forEach(Sensor::closeSensor);
        substationList.forEach(Substation::closeSubstation);
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }

        try {
            boolean isFinishedOnTime = executorService.awaitTermination(TIME_LIMIT_IN_SECONDS, TimeUnit.SECONDS);
            if (isFinishedOnTime) {
                log.info("Program execution was finished on time");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Main thread was interrupted during awaiting termination");
        }
    }

    private static List<Substation> getSubstationList(MonitoringSystem monitoringSystem) {
        return List.of(
                new Substation(1, monitoringSystem, executorService),
                new Substation(2, monitoringSystem, executorService),
                new Substation(3, monitoringSystem, executorService),
                new Substation(4, monitoringSystem, executorService),
                new Substation(5, monitoringSystem, executorService),
                new Substation(6, monitoringSystem, executorService),
                new Substation(7, monitoringSystem, executorService),
                new Substation(8, monitoringSystem, executorService),
                new Substation(9, monitoringSystem, executorService),
                new Substation(10, monitoringSystem, executorService)
        );
    }

    private static List<Sensor> getSensorList(Substation substation) {
        return List.of(
                new Sensor(1, substation, executorService),
                new Sensor(2, substation, executorService),
                new Sensor(3, substation, executorService),
                new Sensor(4, substation, executorService),
                new Sensor(5, substation, executorService),
                new Sensor(6, substation, executorService),
                new Sensor(7, substation, executorService),
                new Sensor(8, substation, executorService),
                new Sensor(9, substation, executorService),
                new Sensor(10, substation, executorService)
        );
    }
}
