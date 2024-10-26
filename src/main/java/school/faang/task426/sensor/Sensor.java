package school.faang.task426.sensor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.faang.task426.substation.Substation;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    @Getter
    private int id;
    @Getter
    private Substation substation;

    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public void startGeneratingData() {
        service.scheduleAtFixedRate(() -> {
            substation.receiveData(id, new Random().nextDouble(99));
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stopGeneratingData() {
        service.shutdown();
    }
}
