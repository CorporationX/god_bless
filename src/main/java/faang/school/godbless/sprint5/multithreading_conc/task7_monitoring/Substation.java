package faang.school.godbless.sprint5.multithreading_conc.task7_monitoring;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {

    @Getter
    private final int id;

    private final MonitoringSystem monitoringSystem;

    private final ConcurrentHashMap<Integer, SensorData> sensorData;

    private final int timeMonitoring = 5;

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
        this.sensorData = new ConcurrentHashMap<>();
        createSensor();
    }

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(5);

    public void receiveData(int sensorId, double data) {
        if (sensorData.containsKey(sensorId)) {
            sensorData.get(sensorId).addData(data);
        } else {
            SensorData sd = new SensorData();
            sd.addData(data);
            sensorData.put(sensorId, sd);
        }
        sensorData.get(sensorId).addData(data);
    }

    public void startCalculatingAverages(){
        SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(() -> {
            double avg = sensorData.values().stream()
                    .map(SensorData::getAvg)
                    .mapToDouble(x -> x)
                    .average()
                    .getAsDouble();
            monitoringSystem.updateData(id, avg);
            sensorData.get(id).reset();
        }, timeMonitoring, timeMonitoring, TimeUnit.SECONDS);
    }

    private void createSensor() {
        for (int i = 1; i < 11; i++) {
            Sensor sensor = new Sensor(i, this);
            sensor.startGettingData();
        }
    }
}
