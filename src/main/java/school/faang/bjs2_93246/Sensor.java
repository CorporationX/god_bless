package school.faang.bjs2_93246;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Sensor {
    @Getter
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startGeneratingData() {
        Runnable task = () -> {
            double data = Math.random() * 100;
            substation.receiveData(id, data);
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
