package school.faang.sprint_4.tracking_system;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class TransportManagementSystem {
    public static ConcurrentHashMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public static void addVehicle(Vehicle vehicle) {
        Objects.requireNonNull(vehicle, "Vehicle cannot be null");
        vehicles.putIfAbsent(vehicle.getId(), vehicle);
    }

    public static void updateVehicle(String vehicleId, Location newLocation) {
        Objects.requireNonNull(newLocation, "New location cannot be null");
        checkMapHasVehicle(vehicleId);
        vehicles.get(vehicleId).setLocation(newLocation);
    }

    public static void getVehicleInfo(String vehicleId) {
        checkMapHasVehicle(vehicleId);

        log.info("Vehicle info: id: {}, location: {}, status:{}",
                vehicleId, vehicles.get(vehicleId).getLocation(), vehicles.get(vehicleId).getStatus());
    }

    private static void checkMapHasVehicle(String vehicleId) {
        Objects.requireNonNull(vehicleId, "Vehicle ID cannot be null");
        if (!vehicles.containsKey(vehicleId)) {
            throw new IllegalArgumentException("HashMap doesn't contain key");
        }
        if (vehicles.get(vehicleId) == null) {
            throw new IllegalArgumentException("HashMap haven't value for key");
        }
    }
}
