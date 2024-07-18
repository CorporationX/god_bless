package faang.school.godbless.substations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
@AllArgsConstructor
public class Sensor {
    private final int TIME_INTERVAL = 1;
    private final double LOWER_BOUND = 0.0;
    private final double UPPER_BOUND = 100.0;

    private int id;
    private Substation substation;
    private ScheduledExecutorService executorService;

    public void startGeneratingData() {
        executorService.scheduleAtFixedRate(() -> {
            double data = generateData();
            substation.receiveData(id, data);
            log.info("Sensor with id: " + id + " generated data: " + data);
        }, TIME_INTERVAL, TIME_INTERVAL, TimeUnit.SECONDS);
    }

    private double generateData() {
        return ThreadLocalRandom.current().nextDouble(LOWER_BOUND, UPPER_BOUND);
    }

    public void closeSensor() {
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
