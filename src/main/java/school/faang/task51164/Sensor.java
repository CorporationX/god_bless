package school.faang.task51164;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Sensor {

    private static final int RANGE_RANDOM = 100;

    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public void startGenerationData() {
        service.scheduleAtFixedRate(() -> substation
                        .receiveData(id, ThreadLocalRandom.current().nextDouble(RANGE_RANDOM)),
                0, 5, TimeUnit.SECONDS);
    }

    public void stopGeneration() {
        service.shutdown();
        try {
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Произошла ошибка при обработке данных", e);
        }
    }
}
