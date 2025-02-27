package school.faang;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(() -> {
            double data = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        executor.shutdownNow();
    }
}
