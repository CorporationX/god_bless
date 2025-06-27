package school.faang.bjs2_83165;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void startGeneratingData() {
        scheduler.scheduleAtFixedRate(() -> {
            double data = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
            substation.receiveData(id, data);
            log.info("Sensor {} sent data: {}", id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
