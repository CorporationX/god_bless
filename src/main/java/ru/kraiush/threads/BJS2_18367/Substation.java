package ru.kraiush.threads.BJS2_18367;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Substation implements Runnable {

    private int id;
    private List<Sensor> listSensors;
    private double data;
    private ConcurrentHashMap<Integer, Double> mapCurrentSensorsData;
    private List<SensorData> listSensorsData;

    public Substation(int id, List<SensorData> listSensorsData) {
        this.id = id;
        this.listSensorsData = listSensorsData;
        listSensors = new ArrayList<>();
        mapCurrentSensorsData = new ConcurrentHashMap<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < listSensors.size(); i++) {
            mapCurrentSensorsData = receiveData(i, listSensors.get(i).generatingData());

            for (int k = 0; k < listSensorsData.size(); k++) {
                if (listSensorsData.get(k).getSubstationId() == id) {
                    if (listSensorsData.get(k).getSensorId() == i) {
                        listSensorsData.get(k).putSensorData(mapCurrentSensorsData.get(i));
                    }
                }
            }
        }
    }

    public ConcurrentHashMap<Integer, Double> receiveData(int sensorId, double data) {
        mapCurrentSensorsData.put(sensorId, data);
        return mapCurrentSensorsData;
    }

    public static Double calculatingAverages(List<SensorData> listSensorsData, int id) {
        double average = 0.0;
        int count = 0;
        for (int i = 0; i < listSensorsData.size(); i++) {
            if (listSensorsData.get(i).getSubstationId() == id) {
                average = average + listSensorsData.get(i).getListSensorData().stream()
                        .mapToDouble(d -> d)
                        .average()
                        .orElse(0.0);
                count = count + 1;
            }
        }
        return average / count;
    }
}
