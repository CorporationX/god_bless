package faang.school.godbless.trackingsystem;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class TransportManagementSystem {
    private final Map<Long, Vehicle> vehicles;
    private final Random random;

    public TransportManagementSystem() {
        this.vehicles = new ConcurrentHashMap<>();
        this.random = new Random();
    }

    public void addVehicle(Vehicle vehicle) {
        log.info("Adding vehicle {}", vehicle);
        vehicles.putIfAbsent(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(Vehicle vehicle) {
        Location currentLocation = vehicle.getLocation();
        double newLatitude = currentLocation.latitude() + (random.nextDouble() - 0.5) * 0.01;
        double newLongitude = currentLocation.longitude() + (random.nextDouble() - 0.5) * 0.01;
        Location newLocation = new Location(newLatitude, newLongitude);
        vehicle.setLocation(newLocation);
        log.info("Updated location of {} to {}", vehicle.getId(), newLocation);
    }

    public void updateVehicleStatus(Vehicle vehicle) {
        Status newStatus = random.nextBoolean() ? Status.FREE : Status.BUSY;
        vehicle.setStatus(newStatus);
        log.info("Updated status of {} to {}", vehicle.getId(), newStatus);
    }
}