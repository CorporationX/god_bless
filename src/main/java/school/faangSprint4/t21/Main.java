package school.faangSprint4.t21;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        for (int substationId = 1; substationId <= 3; substationId++) {
            Substation substation = new Substation(substationId, monitoringSystem);

            for (int sensorId = 1; sensorId <= 10; sensorId++) {
                Sensor sensor = new Sensor(sensorId, substation);
                sensor.startGeneratingData();
            }

            substation.startCalculatingAverages();
        }

        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Monitoring completed");
        System.exit(0);
    }
}