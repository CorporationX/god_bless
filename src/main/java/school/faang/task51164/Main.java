package school.faang.task51164;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(monitoringSystem, 1);
        Substation substation2 = new Substation(monitoringSystem, 2);

        CompletableFuture.runAsync(() -> {
            IntStream.range(0, 10).forEach(i -> {
                new Sensor(i, substation1).startGenerationData();
                new Sensor(i, substation2).startGenerationData();
            });
            substation1.startCalculatingAverages();
            substation2.startCalculatingAverages();
        }).join();
    }
}
