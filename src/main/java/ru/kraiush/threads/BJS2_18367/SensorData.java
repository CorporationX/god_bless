package ru.kraiush.threads.BJS2_18367;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SensorData {

    private int substationId;
    private int sensorId;
    private List<Double> listSensorData = new ArrayList<>();

    public SensorData(int substationId, int sensorId) {
        this.substationId = substationId;
        this.sensorId = sensorId;
    }

    public void putSensorData(double data) {
        listSensorData.add(data);
    }
}
