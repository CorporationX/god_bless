package school.faang.task_51442;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Sensor {
    private final int id;
    private final Substation substation;

    public void startGeneratingData() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            double data = Math.random() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);
    }
}
