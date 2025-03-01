package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class TransportManagementSystem {
    private static final int VEHICLE_UPDATE_LOCATION_LATENCY_MS = 1000;
    private final Map<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
        log.info("Vehicle with id {} added to management system.", vehicle.getId());
    }

    public void updateVehicleLocation(int id, Location newLocation) {
        Vehicle vehicle = vehicles.get(id);
        vehicle.updateStatus(Status.OCCUPIED);
        try {
            Thread.sleep(VEHICLE_UPDATE_LOCATION_LATENCY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sleep interrupted in 'updateVehicleLocation'");
        }
        vehicle.updateLocation(newLocation);
        vehicle.updateStatus(Status.FREE);
        log.info("Location for vehicle with id {} updated. New location: {}",
                id, newLocation.getCoordinates());
    }
}
