package faang.school.godbless.multi_con.task5traking;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final TransportManagementSystem managementSystem;
    private final ScheduledExecutorService executorService;

    public VehicleTracker(TransportManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
        this.executorService = Executors.newScheduledThreadPool(10);
    }

    public void startTracking() {
        managementSystem.getVehicles().values().forEach(vehicle -> {
            executorService.scheduleAtFixedRate(() -> {

                // Генерация случайного изменения местоположения и статуса
                double diffLatitude = Math.random() * 0.01 - 0.005; // Небольшой случайный сдвиг по широте
                double diffLongitude = Math.random() * 0.01 - 0.005; // Небольшой случайный сдвиг по долготе
                String newStatus = Math.random() > 0.5 ? "Свободен" : "Занят"; // Случайное изменение статуса

                managementSystem.updateVehicle(vehicle.getId(), newStatus, diffLatitude, diffLongitude);

                // Вывод информации в консоль
                System.out.println("Транспортное средство с ID: " + vehicle.getId() +
                        " обновлено. Статус: " + newStatus +
                        ", Широта: " + (vehicle.getLocation().getLatitude() + diffLatitude) +
                        ", Долгота: " + (vehicle.getLocation().getLongitude() + diffLongitude));
            }, 0, 1, TimeUnit.SECONDS);
        });
    }

    public void stopTracking() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        TransportManagementSystem managementSystem = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker(managementSystem);

        for (int i = 0; i < 10; i++) {
            managementSystem.addVehicle(new Vehicle(i, "Свободен", new Location(0, 0)));
        }

        vehicleTracker.startTracking();

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        vehicleTracker.stopTracking();
    }
}

