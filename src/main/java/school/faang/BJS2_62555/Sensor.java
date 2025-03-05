package school.faang.BJS2_62555;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private static final long GENERATE_PERIOD_SEC = 1;
    private static final int POOL_SIZE = 1;
    private static final int INITIAL_TASK_DELAY = 0;

    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(() -> {
            double data = ThreadLocalRandom.current().nextDouble(0.5, 10);
            substation.receiveData(id, data);
        }, INITIAL_TASK_DELAY, GENERATE_PERIOD_SEC, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
