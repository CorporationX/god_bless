package school.faang.bjs2_93248;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {

        MonitoringSystem monitoringSystem = new MonitoringSystem();

        int numberOfSubstations = 3;
        int sensorsPerSubstation = 10;

        List<Substation> substations = IntStream.range(0, numberOfSubstations)
                .mapToObj(i -> new Substation(i + 1, monitoringSystem))
                .toList();

        substations.forEach(Substation::startCalculatingAverages);

        List<Sensor> sensors = new CopyOnWriteArrayList<>();

        substations.forEach(substation ->
                IntStream.rangeClosed(1, sensorsPerSubstation).forEach(sensorId -> {
                    Sensor sensor = new Sensor(sensorId, substation);
                    sensor.startGeneratingData();
                    sensors.add(sensor);
                })
        );

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            log.error("Main thread interrupted", e);
            Thread.currentThread().interrupt();
        }

        sensors.forEach(Sensor::shutdown);
        substations.forEach(Substation::shutdown);

        log.info("Мониторинг остановлен");
    }
}