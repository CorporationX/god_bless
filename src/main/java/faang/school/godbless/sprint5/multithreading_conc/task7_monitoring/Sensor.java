package faang.school.godbless.sprint5.multithreading_conc.task7_monitoring;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sensor {

    private final int id;

    private final Substation substation;

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    @SneakyThrows
    public void startGettingData() {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Датчик № " + id + " подстанции № " + substation.getId() + " запущен");
        Runnable task = () -> {
            double data = new Random().nextDouble(1.0, 10.0);
            substation.receiveData(id, data);
        };
        scheduled.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
