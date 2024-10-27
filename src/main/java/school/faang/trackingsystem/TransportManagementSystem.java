package school.faang.trackingsystem;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class TransportManagementSystem {
    private final Map<String, Vehicle> vehicles = new ConcurrentHashMap<>();

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
