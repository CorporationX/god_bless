package faang.school.godbless.concurrency.trackingSystem;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class TransportManagementSystem {
    private final ConcurrentHashMap<Integer, Vehicle> transportBase = new ConcurrentHashMap<>();

    public void addVehicle(@NonNull Vehicle vehicle) {
        transportBase.put(vehicle.getId(), vehicle);
    }

    public synchronized void updateVehicleLocation(int vehicleId, @NonNull Location newLocation) {
        var vehicleToBeUpdated = transportBase.get(vehicleId);

        if (vehicleToBeUpdated == null) {
            log.warn("The transport base doesn't contain vehicle with id " + vehicleId);
            return;
        }

        vehicleToBeUpdated.setCurrentLocation(newLocation);
        log.info("Vehicle with id = " + vehicleId + " is now in " + newLocation);
    }

    public synchronized void updateVehicleLStatus(int vehicleId, boolean newStatus) {
        var vehicleToBeUpdated = transportBase.get(vehicleId);

        if (vehicleToBeUpdated == null) {
            log.warn("The transport base doesn't contain vehicle with id " + vehicleId);
            return;
        }

        vehicleToBeUpdated.setStatus(newStatus);
        log.info("Vehicle with id = " + vehicleId + " is now taken = " + newStatus);
    }

    public Collection<Vehicle> getVehiclesInfo() {
        return transportBase.values();
    }

    public int getVehiclesAmount() {
        return transportBase.size();
    }
}
