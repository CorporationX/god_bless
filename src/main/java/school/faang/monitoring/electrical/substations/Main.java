package school.faang.monitoring.electrical.substations;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int MIN_NUM_OF_SENSORS = 10;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);
        Substation substation3 = new Substation(3, monitoringSystem);
        List<Substation> substations = List.of(substation1, substation2, substation3);

        List<Sensor> sensors = substations.stream()
                .flatMap(substation -> IntStream.range(0, MIN_NUM_OF_SENSORS)
                        .mapToObj(i -> substation.createSensor())
                )
                .toList();

        substations.forEach(Substation::startCalculatingAverages);
        List<CompletableFuture<Void>> futures = sensors.stream()
                .flatMap(sensor -> IntStream.range(0, 3)
                        .mapToObj(i -> CompletableFuture.runAsync(sensor::startGeneratingData))
                )
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((res, ex) -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e);
                    }
                    if (ex != null) {
                        log.error("Не все задачи были завершены: " + ex.getMessage(), ex);
                    } else {
                        System.out.println("Все задачи успешно завершены!");
                    }
                    Substation.shutdown();
                })
                .join();
    }
}
