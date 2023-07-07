package faang.school.godbless.sprint4.electro;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Sensor {
    private int id;
    private Substation substation;

    public void startGeneratingData() {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> {
            double random = new Random().nextDouble();
            substation.receiveData(id, random);
        };
        scheduled.scheduleAtFixedRate(task, 0L, 1000L, TimeUnit.MILLISECONDS);
    }
}
