package school.faangSprint4.t21;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sensor {
    private final int id;
    private final Substation substation;
    private final Random random;
    private final ScheduledExecutorService executor;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        this.random = new Random();
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(() -> {
            double data = random.nextDouble() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        executor.shutdown();
    }
}