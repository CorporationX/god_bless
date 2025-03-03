package school.faang.trackingsystem;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Slf4j
@Getter
public class TransportManagementSystem {
    private final Map<UUID, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        validateVehicle(vehicle);
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(UUID vehicleId, Location location) {
        if (!isVehicleValid(vehicleId, location)) {
            return;
        }
        Vehicle vehicle = vehicles.get(vehicleId);
        vehicle.updateLocation(location);
    }

    public void getVehicleInfo(UUID vehicleId) {
        Vehicle vehicle = vehicles.get(vehicleId);
        String formatLatitude = String.format("%.2f", vehicle.getLocation().latitude());
        String formatLongitude = String.format("%.2f", vehicle.getLocation().longitude());
        log.info("Vehicle: {}, location: {};{}, status: {}", vehicle.getName(),
                formatLatitude, formatLongitude, vehicle.getStatus());
    }

    private void validateVehicle(Vehicle vehicle) {
        Objects.requireNonNull(vehicle, "Invalid vehicle value");
    }

    private boolean isVehicleValid(UUID vehicleId, Location location) {
        Objects.requireNonNull(location, "Invalid location value");
        if (!vehicles.containsKey(vehicleId)) {
            log.info("{} vehicle not found", vehicleId);
            return false;
        }
        return true;
    }
}
