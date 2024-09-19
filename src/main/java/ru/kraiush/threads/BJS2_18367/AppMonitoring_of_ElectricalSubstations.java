package ru.kraiush.threads.BJS2_18367;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppMonitoring_of_ElectricalSubstations {

    public static void main(String[] args) {

        List<Substation> listSubstations = new ArrayList();
        List<SensorData> listSensorsData = new ArrayList<>();
        MonitoringSystem monitor = new MonitoringSystem(listSubstations);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        for (int i = 0; i < 2; i++) {
            listSubstations.add(new Substation(i, listSensorsData));
            List<Sensor> listSensors = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                listSensors.add(new Sensor(listSubstations.get(i).getId(), j));
                listSensorsData.add(new SensorData(i, j));
            }
            listSubstations.get(i).setListSensors(listSensors);
            executor.scheduleAtFixedRate(listSubstations.get(i), 0, 2, TimeUnit.SECONDS);
        }
        executor.scheduleAtFixedRate(monitor, 3, 20, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
