package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);
        List<Sensor> sensors1 = new ArrayList<>();
        for (int i = 1; i <= 12; ++i) {
            sensors1.add(new Sensor(i, substation1));
        }
        List<Sensor> sensors2 = new ArrayList<>();
        for (int i = 13; i <= 25; ++i) {
            sensors2.add(new Sensor(i, substation2));
        }

        for (Sensor sensor : sensors1) {
            sensor.startGeneratingData();
        }
        for (Sensor sensor : sensors2) {
            sensor.startGeneratingData();
        }

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sleep was interrupted.");
        }

        substation1.stopCalculatingAverages();
        substation2.stopCalculatingAverages();
        for (Sensor sensor : sensors1) {
            sensor.stopGeneratingData();
        }
        for (Sensor sensor : sensors2) {
            sensor.stopGeneratingData();
        }
    }
}
