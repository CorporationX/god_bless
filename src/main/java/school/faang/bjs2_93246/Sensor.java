package school.faang.bjs2_93246;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Getter
public class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }
}
