package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void startGeneratingData() {
        try {
            executor.scheduleAtFixedRate(() -> {
                double data = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
                substation.receiveData(id, data);
            }, 0, 1, TimeUnit.SECONDS);
        } catch (RejectedExecutionException e) {
            log.error("The task cannot be scheduled because the executor service has stopped.");
        }
    }


    public void stopGeneratingData() {
        executor.shutdownNow();
    }
}
