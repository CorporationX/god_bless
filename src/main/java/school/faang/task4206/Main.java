package school.faang.task4206;

import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData() {
        scheduler.scheduleAtFixedRate(() -> {
            double data = new Random().nextDouble() * 100;
            substation.receiveData(id, data);
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 3, TimeUnit.SECONDS);
    }
}

class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final ConcurrentHashMap<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addData(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(() -> {
            double totalSum = sensorDataMap.values().stream().mapToDouble(SensorData::getSum).sum();
            long totalCount = sensorDataMap.values().stream().mapToLong(SensorData::getCount).sum();
            double average = totalCount > 0 ? totalSum / totalCount : 0;
            monitoringSystem.updateData(id, average);
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 3, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}

class SensorData {
    private double sum;
    private long count;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public synchronized double getSum() {
        return sum;
    }

    public synchronized long getCount() {
        return count;
    }

    public synchronized double getAverage() {
        return count > 0 ? sum / count : 0;
    }
}

class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.println("Подстанция " + substationId + ": среднее значение данных: " + averageData);
    }
}

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);

        for (int i = 0; i < 10; i++) {
            new Sensor(i, substation1).startGeneratingData();
            new Sensor(i + 10, substation2).startGeneratingData();
        }

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            substation1.shutdown();
            substation2.shutdown();
            System.out.println("Завершение работы системы мониторинга");
        }));
    }
}

