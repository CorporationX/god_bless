package derschrank.sprint04.task20.bjstwo_51174;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String SPLITTER = "\n=============================\n";
    private static final int COUMT_OF_SUBSTATIONS = 10;
    private static final int COUNT_OF_SENSORS = 10;
    private static final int TIME_FOR_PROGRAM_MILLIS = 6000;

    public static void main(String[] args) {
        MonitoringSystem system = new MonitoringSystem();

        List<Substation> subs = new LinkedList<>();
        List<Sensor> sensors = new LinkedList<>();

        generateSubstationsAndSensors(subs, sensors, system);

        startSchedule(subs, sensors);
        toSleep(TIME_FOR_PROGRAM_MILLIS);
        stopSchedule(subs, sensors);

    }

    private static void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateSubstationsAndSensors(
            List<Substation> subs, List<Sensor> sensors, MonitoringSystem system) {
        for (int i = 0; i < COUMT_OF_SUBSTATIONS; i++) {
            Substation substation = new Substation(i, system);
            subs.add(substation);
            for (int j = 0; j < COUNT_OF_SENSORS; j++) {
                final int sensorId = i * 1000 + j;
                Sensor sensor = new Sensor(sensorId, substation);
                sensors.add(sensor);
            }
        }
    }

    private static void startSchedule(List<Substation> subs, List<Sensor> sensors) {
        System.out.println(SPLITTER + "Starting schedule..." + SPLITTER);
        for (Sensor sensor : sensors) {
            sensor.startGeneratingData();
        }

        for (Substation substation : subs) {
            substation.startCalculatingAverages();
        }
    }

    private static void stopSchedule(List<Substation> subs, List<Sensor> sensors) {
        System.out.println(SPLITTER + "Stopping schedule..." + SPLITTER);
        for (Sensor sensor : sensors) {
            sensor.stopGeneratingData();
        }

        for (Substation substation : subs) {
            substation.stopCalculatingAverages();
        }
    }
}
