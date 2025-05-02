package school.faang.concurrency.tracking_system;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    public static void main(String[] args) {

        TransportManagementSystem system = new TransportManagementSystem();

        system.addVehicle(new Vehicle("Car"));
        system.addVehicle(new Vehicle("Bus"));
        system.addVehicle(new Vehicle("Boat"));
        system.addVehicle(new Vehicle("Plane"));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        system.getVehicleMap().keySet()
                .forEach((vehicleId) ->
                        executorService.scheduleAtFixedRate(() -> {
                            Location newLocation = generateRandomLocation();
                            String newStatus = generateRandomStatus();
                            system.updateVehicleLocation(system.getVehicleMap().get(vehicleId), newLocation);
                            system.updateVehicleStatus(system.getVehicleMap().get(vehicleId), newStatus);
                            log.info("Vehicle info: {}", system.getVehicleInfo(vehicleId));
                        }, 0, 5, TimeUnit.SECONDS));

    }

    private static Location generateRandomLocation() {
        Random rnd = new Random();
        return new Location(rnd.nextLong(), rnd.nextLong());
    }

    private static String generateRandomStatus() {
        Random rnd = new Random();
        return rnd.nextBoolean() ? "Free" : "Taken";
    }
}
