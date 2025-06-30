package school.faang.bjs2_83165;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        int substationsCount = 3;
        List<Substation> substations = new ArrayList<>();

        for (int i = 1; i <= substationsCount; i++) {
            substations.add(new Substation(i, monitoringSystem));
        }

        List<Sensor> allSensors = new ArrayList<>();

        for (Substation substation : substations) {
            for (int sensorId = 1; sensorId <= 10; sensorId++) {
                Sensor sensor = new Sensor(sensorId, substation);
                allSensors.add(sensor);
                sensor.startGeneratingData();
                log.info("Started Sensor {} for Substation {}", sensorId, substation.getId());
            }
            substation.startCalculatingAverages();
            log.info("Started average calculation for Substation {}", substation.getId());
        }

        Thread.sleep(3 * 60 * 1000);

        allSensors.forEach(Sensor::stop);
        substations.forEach(substation -> {
        });

        log.info("Monitoring simulation finished.");
    }
}
