package school.faang.BJS2_62555;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private static final int SUBSTATIONS_AMOUNT = 10;
    private static final int SENSORS_AMOUNT = 10;
    private static final int MONITORING_COMPLETION_TIME_SEC = 30;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        List<Substation> substations = IntStream.range(0, SUBSTATIONS_AMOUNT)
                .mapToObj(i -> new Substation(i + 1, monitoringSystem))
                .toList();

        List<Sensor> sensors = new ArrayList<>();
        substations.forEach(substation -> {
            List<Sensor> substationSensors = IntStream.range(0, SENSORS_AMOUNT)
                    .mapToObj(i -> new Sensor(i + 1, substation))
                    .peek(Sensor::startGeneratingData)
                    .toList();

            sensors.addAll(substationSensors);
            substation.startCalculatingAverages();
        });

        try {
            Thread.sleep(MONITORING_COMPLETION_TIME_SEC * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sensors.forEach(Sensor::stopGeneratingData);
        substations.forEach(Substation::stopCalculatingAverages);

        System.out.println("******************************************************");
        monitoringSystem.printAllData();
    }
}
