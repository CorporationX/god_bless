package ru.kraiush.threads.BJS2_18367;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppMonitoring_of_ElectricalSubstations {

    public static void main(String[] args) {

        final List<Substation> listSubstations = new ArrayList();
        final List<SensorData> listSensorsData = new ArrayList<>();
        final MonitoringSystem monitor = new MonitoringSystem(listSubstations);
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        for (int i = 0; i < 3; i++) {
            listSubstations.add(new Substation(i, listSensorsData));
            List<Sensor> listSensors = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                listSensors.add(new Sensor(listSubstations.get(i).getId(), j));
                listSensorsData.add(new SensorData(i, j));
            }
            listSubstations.get(i).setListSensors(listSensors);
            executor.scheduleAtFixedRate(listSubstations.get(i), 0, 2, TimeUnit.SECONDS);
        }
        executor.scheduleAtFixedRate(monitor, 3, 10, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
