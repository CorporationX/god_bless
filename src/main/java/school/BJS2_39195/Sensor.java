package school.BJS2_39195;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sensor {

    private final int id;
    private final Substation substation;
    private final Random rand = new Random();
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData() {
        service.scheduleAtFixedRate(() -> {
            double data = rand.nextInt(400);
            substation.receiveData(id, data);
        }, 0 , 1, TimeUnit.SECONDS);
    }
}
