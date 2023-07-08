package faang.school.godbless.monitoringElectricalSubstations;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class Sensor {
    private final int id;
    private final Substation substation;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData(ScheduledExecutorService executor) {
        Random random = new Random();

        executor.scheduleAtFixedRate(() -> {
            double data = random.nextDouble();
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }

}
