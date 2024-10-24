package school.BJS2_39195;

import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Substation {

    private int id;
    private MonitoringSystem monitoringSystem;
    private ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        SensorData sensorData = new SensorData();
        sensorData.addData(data);
        sensorDataMap.put(sensorId, sensorData);

    }

    public void startCalculatingAverages() {
        service.scheduleAtFixedRate(() -> {
            OptionalDouble sum = sensorDataMap.values().stream().mapToDouble(x -> x.getAverage()).average();
            monitoringSystem.updateData(id, sum.getAsDouble());
        }, 0, 10, TimeUnit.SECONDS);
    }
}
