package school.faang.bjs2_93248;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private final int id;
    private final Substation substation;
    private final Random random = new Random();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(() -> {
            double data = random.nextDouble() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}