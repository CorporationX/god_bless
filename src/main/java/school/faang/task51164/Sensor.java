package school.faang.task51164;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public record Sensor(int id,
                     Substation substation) {

    private static final int RANGE_RANDOM = 100;
    private static final ScheduledExecutorService SERVICE = Executors.newScheduledThreadPool(1);

    public void startGenerationData() {
        SERVICE.scheduleAtFixedRate(() -> substation
                        .receiveData(id, ThreadLocalRandom.current().nextDouble(RANGE_RANDOM)),
                0, 5, TimeUnit.SECONDS);
    }

    public void stopGeneration() {
        SERVICE.shutdown();
        try {
            SERVICE.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Произошла ошибка при обработке данных", e);
        }
    }
}
