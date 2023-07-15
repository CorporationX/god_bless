package faang.school.godbless.monitoringElectricalSubstations;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Substation> substations = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Substation substation = new Substation(i, monitoringSystem);
            substations.add(substation);

            for (int j = 1; j <= 10; j++) {
                Sensor sensor = new Sensor(j, substation);
                sensor.startGeneratingData(getScheduledExecutor());
            }

            substation.startCalculatingAverages(getScheduledExecutor());
        }
    }

    private static ScheduledExecutorService getScheduledExecutor() {
        return Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    }

}
