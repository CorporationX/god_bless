package school.faang.task_51192;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    private static final int SUBSTATION_NUM = 5;
    private static final int SENSOR_NUM = 10;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Substation> substations = new ArrayList<>();
        List<Sensor> sensors = new ArrayList<>();
        CompletableFuture<Void> result = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < SUBSTATION_NUM; i++) {
                Substation substation = new Substation(i, monitoringSystem);
                substations.add(substation);
                Sensor sensor;
                for (int j = 0; j < SENSOR_NUM; j++) {
                    sensor = new Sensor(j, substation);
                    sensors.add(sensor);
                    sensor.startGeneratingData();
                }
            }

            for (Substation substation : substations) {
                substation.startCalculatingAverages();
            }
        });

        try {
            result.get();
        } catch (ExecutionException | InterruptedException e) {
            log.error("Не удалось получить результат работы сервиса мониторинга");
            sensors.forEach(Sensor::stop);
            substations.forEach(Substation::stop);
            Thread.currentThread().interrupt();
        }
    }
}
