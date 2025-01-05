package school.faang.bjs251184;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        Substation substation1 = new Substation(1, monitoringSystem);
        substation1.startCalculatingAverage();

        for (int i = 1; i <= 10; i++) {
            Sensor sensor = new Sensor(i, substation1);
            sensor.startGeneratingData();
        }
    }
}