package school.faang.bjs2_93246;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class Substation {
    private int id;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap;

    public Substation(int id) {
        this.id = id;
        this.sensorDataMap = new ConcurrentHashMap<>();
    }

    public void receiveData(int sensorId, double data) {
        SensorData sensor = sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData());
        sensor.addData(data);
    }
}
