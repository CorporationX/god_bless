package school.faang.gps_tracker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TransportManagementSystem {
    private final ConcurrentMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicle.getId() == null) {
            throw new IllegalArgumentException("Vehicle or vehicle ID must not be null");
        }
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateLocation(newLocation);
        }
    }

    public void updateVehicleStatus(String vehicleId, VehicleStatus newStatus) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateStatus(newStatus);
        }
    }

    public String getVehicleInfo(String vehicleId) {
        Vehicle vehicle = vehicles.get(vehicleId);
        return vehicle != null ? vehicle.toString() : "Vehicle not found";
    }

    public HashMap<String, Vehicle> getAllVehicles() {
        return new HashMap<>(vehicles);
    }
}
