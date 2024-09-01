package faang.school.godbless.BJS2_25580;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(20);
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    private int id;
    private Substation substation;

    public void startGeneratingData() {
        executor.scheduleAtFixedRate(() -> {
            System.out.println(id + " sensor generating data");
            SensorData data = new SensorData(
                    random.nextDouble(1, 1000),
                    random.nextDouble(1, 1000)
            );
            substation.receiveData(id, data);

        }, 0, 1, TimeUnit.SECONDS);
    }
}
