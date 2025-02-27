package bjs2_62545;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Substation {
    public static final int INTERVAL_MINUTES = 1;
    public static final int WAITING_TERMINATION_TIMEOUT_MS = 500;

    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        var sensorData = new SensorData(data);

        sensorData = sensorDataMap.putIfAbsent(sensorId, sensorData);
        if (sensorData != null) {
            // Данные с датчика уже были в мапе => добавляем новое значение
            sensorData.addData(data);
        }
    }

    public Runnable startCalculatingAverages() {
        var scheduledExecutor = Executors.newScheduledThreadPool(1);

        log.info("Запущено вычисление среднего для подстанции {}", id);
        scheduledExecutor.scheduleAtFixedRate(
                this::calculateAllSensorsAverage,
                0,
                INTERVAL_MINUTES,
                TimeUnit.MINUTES);

        return new ForeverOperationStopper(
                WAITING_TERMINATION_TIMEOUT_MS,
                scheduledExecutor,
                String.format("Остановлено вычисление среднего для подстанции %d", id));
    }

    private void calculateAllSensorsAverage() {
        var currentValues = sensorDataMap.values().stream().map(SensorData::clone).toList();

        var allSensorValuesCount = currentValues.stream().map(SensorData::getCount).mapToInt(x -> x).sum();
        if (allSensorValuesCount == 0) {
            return;
        }

        var sumOfAllSensorData = currentValues.stream()
                .map(x -> x.getAverage() * x.getCount())
                .mapToDouble(x -> x)
                .sum();

        monitoringSystem.updateData(id, sumOfAllSensorData / allSensorValuesCount);
    }
}
