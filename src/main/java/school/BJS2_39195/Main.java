package school.BJS2_39195;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MonitoringSystem monitoringSystem = new MonitoringSystem();

        List<Substation> substations = new ArrayList<>();
        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);
        Substation substation3 = new Substation(3, monitoringSystem);
        Substation substation4 = new Substation(4, monitoringSystem);
        Substation substation5 = new Substation(5, monitoringSystem);
        substations.add(substation1);
        substations.add(substation2);
        substations.add(substation3);
        substations.add(substation4);
        substations.add(substation5);

        for (Substation substation : substations) {
            for (int i = 0; i < 10; i++) {
                Sensor sensor = new Sensor(i , substation);
                sensor.startGeneratingData();
            }
            substation.startCalculatingAverages();
        }
    }
}