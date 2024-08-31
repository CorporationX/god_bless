package faang.school.godbless.substationsmonitoring;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startGeneratingData() {
        scheduler.scheduleAtFixedRate(() -> {
            double data = new Random().nextDouble() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }
}