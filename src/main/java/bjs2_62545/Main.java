package bjs2_62545;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static final int SUBSTATIONS_COUNT = 5;
    public static final int SENSORS_PER_SUBSTATION = 13;
    public static final int SIMULATION_TIME_MS = 3 * 60 * 1000;

    public static void main(String[] args) {
        var monitoringSystem = new MonitoringSystem();
        var substations = new Substation[SUBSTATIONS_COUNT];
        List<Runnable> substationStoppers = new ArrayList<>();
        var sensors = new ArrayList<Sensor>();

        for (int substationIndex = 0; substationIndex < substations.length; substationIndex++) {
            substations[substationIndex] = new Substation(substationIndex, monitoringSystem);
            substationStoppers.add(substations[substationIndex].startCalculatingAverages());

            for (int sensorIndex = 0; sensorIndex < SENSORS_PER_SUBSTATION; sensorIndex++) {
                var sensor = new Sensor(
                        substationIndex * SENSORS_PER_SUBSTATION + sensorIndex,
                        substations[substationIndex]);
                sensors.add(sensor);
            }
        }

        List<Runnable> sensorStoppers = new ArrayList<>();
        for (var sensor : sensors) {
            sensorStoppers.add(sensor.startGeneratingData());
        }

        try {
            Thread.sleep(SIMULATION_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Ошибка в ходе работы: {}", e.getMessage(), e);
        }

        // Останавливаем все вычисления принудительно
        sensorStoppers.forEach(Runnable::run);
        substationStoppers.forEach(Runnable::run);
    }
}
