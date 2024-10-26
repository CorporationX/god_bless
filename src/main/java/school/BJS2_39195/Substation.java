package school.BJS2_39195;

import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        service.scheduleAtFixedRate(() -> {
            OptionalDouble sum = sensorDataMap.values().stream().mapToDouble(SensorData::getAverage).average();
            if(sum.isPresent()) {
                monitoringSystem.updateData(id, sum.getAsDouble());
            }
        }, 0, 10, TimeUnit.SECONDS);
    }
}
