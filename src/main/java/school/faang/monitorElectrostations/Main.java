package school.faang.monitorElectrostations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);
        List<Sensor> sensors = new ArrayList<>();
        List<Substation> substations = List.of(substation1, substation2);
        for (Substation substation : substations) {
            for (int i = 0; i < 10; i++) {
                Sensor sensor = new Sensor(i, substation);
                sensor.startGeneratingData();
                sensors.add(sensor);
            }
            substation.startCalculatingAverages();
        }

        try {
            Thread.sleep(70_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Unable to wait for the sensors and substations to finish");
        }

        for (Sensor sensor : sensors) {
            sensor.stopGeneratingData();
        }
        for (Substation substation : substations) {
            substation.stopCalculatingAverages();
        }
    }
}
