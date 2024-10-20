package ru.kraiush.threads.BJS2_18367;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem implements Runnable {

    private List<Substation> listSubstations;
    private ConcurrentHashMap<Integer, ArrayList<Double>> mapSubstationsData;
    private ArrayList<ArrayList<Double>> sublist;

    public MonitoringSystem(List<Substation> listSubstations) {
        this.listSubstations = listSubstations;
        mapSubstationsData =new ConcurrentHashMap<>();
        sublist = new ArrayList<>();
    }

    @Override
    public void run() {
        updateData(listSubstations);
    }

    void updateData(List<Substation> listSubstations) {

        for (int i = 0; i < listSubstations.size(); i++) {

            Double average = Substation.calculatingAverages(listSubstations.get(i).getListSensorsData(), i);

            if (sublist.isEmpty() || sublist.size() < listSubstations.size()) {
                ArrayList<Double> arr = new ArrayList<>();
                arr.add(average);
                sublist.add(arr);
                mapSubstationsData.put(i, sublist.get(i));
            } else {
                sublist.get(i).add(average);
                mapSubstationsData.put(i, sublist.get(i));
                mapSubstationsData.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));
            }

            System.out.println("\nSTATION: " + i + " average: " + average + " time: " + new Date());
        }
        System.out.println();
    }
}
