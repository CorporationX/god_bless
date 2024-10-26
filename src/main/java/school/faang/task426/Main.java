package school.faang.task426;

import school.faang.task426.sensor.Sensor;
import school.faang.task426.substation.MonitoringSystem;
import school.faang.task426.substation.Substation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Sensor> sensors = new ArrayList<>();
        List<Substation> substations = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Substation substation = new Substation(i, monitoringSystem);
            substations.add(substation);
            for (int j = 0; j < 10; j++) {
                Sensor sensor = new Sensor(j, substation);
                sensor.startGeneratingData();
                sensors.add(sensor);
            }
            substation.startCalculatingAverages();
        }

        try {
            Thread.sleep(61000);
            monitoringSystem.printAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sensors.forEach(Sensor::stopGeneratingData);
        substations.forEach(Substation::stopGeneratingData);
    }
}
