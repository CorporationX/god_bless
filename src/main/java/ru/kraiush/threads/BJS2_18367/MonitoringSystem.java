package ru.kraiush.threads.BJS2_18367;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem implements Runnable {

    private List<Substation> listSubstations;

    public MonitoringSystem(List<Substation> listSubstations) {
        this.listSubstations = listSubstations;
    }

    ConcurrentHashMap<Integer, Double> mapSubstationsData = new ConcurrentHashMap<>();

    @Override
    public void run() {
        updateData(listSubstations);
    }

    void updateData(List<Substation> listSubstations) {
        for (int i = 0; i < listSubstations.size(); i++) {
            Double average = Substation.calculatingAverages(listSubstations.get(i).getListSensorsData(), i);
            mapSubstationsData.put(i, average);
            System.out.println("STATION: " + i + " average: " + average + " time: " + new Date());
        }
        System.out.println();
    }
}
