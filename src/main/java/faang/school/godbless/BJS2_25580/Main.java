package faang.school.godbless.BJS2_25580;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Substation> substations = IntStream.rangeClosed(1, 5)
                .mapToObj(id -> new Substation(id, monitoringSystem))
                .toList();

        int counter = 1;
        List<Sensor> sensors = new ArrayList<>();
        for (Substation substation : substations) {
            for (int i = 0; i < 2; i++) {
                sensors.add(new Sensor(counter++, substation));
            }
        }

        sensors.forEach(Sensor::startGeneratingData);
        substations.forEach(Substation::startCalculatingAverages);
    }
}
