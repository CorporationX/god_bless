package derschrank.sprint04.task20.bjstwo_51174;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@EqualsAndHashCode
public class Sensor {
    private static final double MAX_DATA = 100.0;
    private static final int GENERATION_PERIOD_MILLIS = 1000;

    @Getter
    private final int id;
    @Getter
    private final Substation substation;
    private final Random rnd;
    private final ScheduledExecutorService executor;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        rnd = ThreadLocalRandom.current();
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(
                () -> substation.receiveData(id, getData()),
                0,
                GENERATION_PERIOD_MILLIS,
                TimeUnit.MILLISECONDS
        );
    }

    private double getData() {
        return rnd.nextDouble(MAX_DATA);
    }

    public void stopGeneratingData() {
        executor.shutdown();
    }
}
