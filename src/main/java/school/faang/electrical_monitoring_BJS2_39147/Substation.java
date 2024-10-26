package school.faang.electrical_monitoring_BJS2_39147;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Substation {
    public final static int POOL_SIZE = 20;
    public final static int INITIAL_DELAY = 0;

    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(POOL_SIZE);

    private int id;
    private MonitoringSystem monitoringSystem;

    public void receiveData(int sensorId, double value) {
        sensorDataMap.computeIfAbsent(sensorId, (val) -> new SensorData()).addData(value);
    }

    public void startCalculatingAverages() {
        int period = 60;

        service.scheduleAtFixedRate(() -> monitoringSystem.updateData(id, sensorDataMap.values().stream()
                .mapToDouble(SensorData::getAverage)
                .average().orElse(0.0)), INITIAL_DELAY, period, TimeUnit.SECONDS);
    }
}