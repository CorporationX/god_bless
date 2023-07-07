package faang.school.godbless.ElectricalSubstations;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem ms = new MonitoringSystem();
        Substation substation1 = new Substation(1, ms);
        Substation substation2 = new Substation(2, ms);
        Substation substation3 = new Substation(3, ms);
        List<Sensor> sensors1 = generateSensors(substation1);
        List<Sensor> sensors2 = generateSensors(substation2);
        List<Sensor> sensors3 = generateSensors(substation3);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(6);

        executor.scheduleAtFixedRate(() -> sensors1.forEach(Sensor::startGeneratingData), 0,
                1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(() -> sensors2.forEach(Sensor::startGeneratingData), 0,
                1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(() -> sensors3.forEach(Sensor::startGeneratingData), 0,
                1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(substation1::startCalculatingAverage, 0,
                1, TimeUnit.MINUTES);
        executor.scheduleAtFixedRate(substation2::startCalculatingAverage, 0,
                1, TimeUnit.MINUTES);
        executor.scheduleAtFixedRate(substation3::startCalculatingAverage, 0,
                1, TimeUnit.MINUTES);
    }

    public static List<Sensor> generateSensors(Substation substation) {
        return List.of(
                new Sensor((10 * substation.getId()), substation),
                new Sensor(2 * (10 * substation.getId()), substation),
                new Sensor(3 * (10 * substation.getId()), substation),
                new Sensor(4 * (10 * substation.getId()), substation),
                new Sensor(5 * (10 * substation.getId()), substation),
                new Sensor(6 * (10 * substation.getId()), substation),
                new Sensor(7 * (10 * substation.getId()), substation),
                new Sensor(8 * (10 * substation.getId()), substation),
                new Sensor(9 * (10 * substation.getId()), substation),
                new Sensor(10 * (10 * substation.getId()), substation)
        );
    }
}
