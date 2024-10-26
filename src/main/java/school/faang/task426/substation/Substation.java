package school.faang.task426.substation;

import school.faang.task426.sensor.Sensor;
import school.faang.task426.sensor.SensorData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {
    private int id;
    private MonitoringSystem monitoringSystem;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, id -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        service.scheduleAtFixedRate(() -> {
            double avg = sensorDataMap.entrySet().stream()
                    .mapToDouble(entry -> entry.getValue().getAverage())
                    .reduce((left, right) -> left + right)
                    .orElse(0) / sensorDataMap.size();
            monitoringSystem.updateData(id, avg);
        }, 0, 1, TimeUnit.MINUTES);
    }

    public void stopGeneratingData() {
        service.shutdown();
    }
}
