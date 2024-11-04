package school.faangSprint4.t22;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final ConcurrentHashMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateLocation(newLocation);
        }
    }

    public Vehicle getVehicleInfo(String vehicleId) {
        return vehicles.get(vehicleId);
    }
}