package school.faang.monitorElectrostations;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private static final int NUM_THREADS = 10;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_THREADS);

    private final int id;
    private final Substation substation;

    public void startGeneratingData() {
        executorService.scheduleAtFixedRate(() -> {
            double data = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        executorService.shutdown();
    }
}
