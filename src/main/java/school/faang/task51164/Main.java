package school.faang.task51164;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        CompletableFuture.supplyAsync(() -> {
            List<Substation> substations = List.of(
                    new Substation(monitoringSystem, 0),
                    new Substation(monitoringSystem, 1));

            List<Sensor> list = new ArrayList<>();

            IntStream.range(0, 10).forEach(i ->
                IntStream.range(0, 2).forEach(j -> {
                    list.add(new Sensor(i, substations.get(j)));
                    list.get(i).startGenerationData();
                }));

            return list;
        }).thenAccept(sensors -> sensors.forEach(Sensor::stopGeneration));
    }
}
