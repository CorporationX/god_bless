package school.faang.sprint_4.task_51154;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_SUBSTATIONS = 5;
    private static final int NUMBER_OF_SENSORS_PER_SUBSTATION = 10;
    private static final int WORKING_TIME = 50000;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Substation> substations = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_SUBSTATIONS; i++) {
            Substation substation = new Substation(i, monitoringSystem);
            substation.startCalculatingAverages();

            for (int j = 1; j <= NUMBER_OF_SENSORS_PER_SUBSTATION; j++) {
                executorService.submit(new Sensor(j, substation));
            }
            substations.add(substation);
        }

        try {
            Thread.sleep(WORKING_TIME);
        } catch (InterruptedException e) {
            log.info("Main thread interrupted");
            Thread.currentThread().interrupt();
        }

        substations.forEach(Substation::stopCalculatingAverages);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.warn("Forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Interrupted while waiting for termination");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
