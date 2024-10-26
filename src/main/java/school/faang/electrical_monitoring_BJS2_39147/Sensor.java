package school.faang.electrical_monitoring_BJS2_39147;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private final Random random = new Random();
    private final ScheduledExecutorService executorService =
            Executors.newScheduledThreadPool(Substation.POOL_SIZE);

    private int id;
    private Substation substation;

    public void StartGenerationData() {
        int valueRange = 100;
        int period = 1;

        executorService.scheduleAtFixedRate(() ->
                        substation.receiveData(id, random.nextDouble(valueRange)),
                Substation.INITIAL_DELAY, period, TimeUnit.SECONDS);
    }
}