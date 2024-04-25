package faang.school.godbless.bjs2_6110;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {

    private static volatile int THREAD_SIZE = 0;

    public static void main(String[] args) throws InterruptedException {
        Vehicle bike = new Vehicle(1, new Location(55.915288, 39.167779));
        Vehicle taxi = new Vehicle(2, new Location(55.922334, 39.171083));
        Vehicle truck = new Vehicle(3, new Location(55.899628, 39.061617));

        TransportManagementSystem transportSystem = new TransportManagementSystem();
        transportSystem.addVehicle(bike);
        transportSystem.addVehicle(taxi);
        transportSystem.addVehicle(truck);

        track(transportSystem);

        TimeUnit.SECONDS.sleep(7);

        transportSystem.addVehicle(new Vehicle(4, new Location(55.899628, 39.061617)));

        TimeUnit.SECONDS.sleep(5);

        transportSystem.removeVehicle(1);
    }

    public static void track(TransportManagementSystem transportSystem) {

        ConcurrentHashMap<Integer, Vehicle> vehicles = transportSystem.getVehicles();
        final ScheduledExecutorService[] executor = {Executors.newScheduledThreadPool(THREAD_SIZE)};
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);

        executor2.scheduleAtFixedRate(() -> {
            //Check if vehicles size changed
            if (vehicles.size() != THREAD_SIZE) {
                log.info("Count of vehicles changed. Was {}, now: {}", THREAD_SIZE, vehicles.size());
                THREAD_SIZE = vehicles.size();
                executor[0].shutdown();
                executor[0] = Executors.newScheduledThreadPool(THREAD_SIZE);
            }
            vehicles.forEach((key, currentVehicle) -> executor[0].schedule(() -> {
                // Вывести ID и Location транспортного средства.
                log.info("{} : {}", key, currentVehicle);
                // Update location and vehicle status
                Location oldLocation = currentVehicle.getLocation();
                double newLatitude = oldLocation.latitude() + ThreadLocalRandom.current().nextDouble(0.0001, 0.000999);
                double newLongitude = oldLocation.longitude() + ThreadLocalRandom.current().nextDouble(0.0001, 0.000999);
                StatusVehicle newStatus = currentVehicle.getStatus().equals(StatusVehicle.FREE) ? StatusVehicle.BUSY : StatusVehicle.FREE;
                //Update vehicle
                transportSystem.updateVehicle(new Vehicle(currentVehicle.getId(), newStatus, new Location(newLatitude, newLongitude)));
            }, 5, TimeUnit.SECONDS));

        }, 0, 5, TimeUnit.SECONDS);
    }
}
