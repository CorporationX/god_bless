package school.faang.bjs251184;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Sensor {

    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public Sensor(int id, Substation substation) {
        if (id <= 0 || substation == null) {
            log.error("Invalid input in Sensor constructor");
            throw new IllegalArgumentException("Invalid input in Sensor constructor");
        }
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData() {
        log.info("Sensor {} started generating data", id);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            double data = Math.random() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        log.info("Sensor {} stopped generating data", id);
        scheduledExecutorService.shutdown();
    }
}