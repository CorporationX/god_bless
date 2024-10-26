package school.faang.electrical_monitoring_BJS2_39147;

import java.util.stream.IntStream;

public class Main {
    private final static int RANGE_FROM = 1;
    private final static int RANGE_TO = 10;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);

        IntStream.range(RANGE_FROM, RANGE_TO).forEach(i -> {
            new Sensor(i, substation1).StartGenerationData();
            new Sensor(i, substation2).StartGenerationData();
        });

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();
    }
}