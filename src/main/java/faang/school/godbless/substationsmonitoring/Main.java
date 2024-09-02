package faang.school.godbless.substationsmonitoring;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        List<Substation> substations = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Substation substation = new Substation(i, monitoringSystem);
            substations.add(substation);
        }
        List<Sensor> sensors = new ArrayList<>();
        for (Substation substation : substations) {
            for (int i = 1; i <= 10; i++) {
                Sensor sensor = new Sensor(i, substation);
                sensors.add(sensor);
            }
        }
        substations.forEach(Substation::startCalculatingAverages);
        sensors.forEach(Sensor::startGeneratingData);
    }
}