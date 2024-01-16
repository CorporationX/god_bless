package faang.school.godbless.Traking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    public static void main(String[] args) {
// Создаем список транспортных средств
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("1", true, new Location(145, 132)));
        vehicles.add(new Vehicle("2", false, new Location(234, 134)));
        vehicles.add(new Vehicle("3", true, new Location(123, 232)));
// Создаем объект транспортного управления
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
// Запускаем цикл сохранения и обновления данных по транспортному управлению
        ScheduledExecutorService service = Executors.newScheduledThreadPool(6);
        for (Vehicle vehicle : vehicles) {
            service.scheduleAtFixedRate(() -> {
                // добавляем транспорт в систему управления
                transportManagementSystem.addVehicle(vehicle);
                // отслеживаем местоположение транспортного средства
                transportManagementSystem.updateVehicleLocation(vehicle);

            }, 0, 2, TimeUnit.SECONDS);
            // отслеживаем состояние транспортного средства. Для примера выполняем обновление статуса каждые 4 секунды. Типа за 4 секунды куда-то доехал и статус обновился
            service.scheduleAtFixedRate(() -> transportManagementSystem.updateVehicleStatus(vehicle), 4, 4, TimeUnit.SECONDS);
            // устанавливаем время, в течение которого будет выполняться обновление данных по транспортным средствам
            service.schedule(service::shutdown, 13, TimeUnit.SECONDS);
        }
        try {
            service.awaitTermination(7, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(transportManagementSystem.getVehicles());// just checking
    }
}
