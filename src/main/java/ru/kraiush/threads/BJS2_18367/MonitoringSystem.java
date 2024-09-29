package ru.kraiush.threads.BJS2_18367;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem implements Runnable {

    private List<Substation> listSubstations;
    private ConcurrentHashMap<Integer, ArrayList<Double>> mapSubstationsData = new ConcurrentHashMap<>();
    private ArrayList<ArrayList<Double>> sublist = new ArrayList<>();

    public MonitoringSystem(List<Substation> listSubstations) {
        this.listSubstations = listSubstations;
    }


    @Override
    public void run() {
        updateData(listSubstations);
    }

    void updateData(List<Substation> listSubstations) {

        for (int i = 0; i < listSubstations.size(); i++) {

            Double average = Substation.calculatingAverages(listSubstations.get(i).getListSensorsData(), i);

            if (sublist.size() == 0 || sublist.size() < listSubstations.size()) {
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
