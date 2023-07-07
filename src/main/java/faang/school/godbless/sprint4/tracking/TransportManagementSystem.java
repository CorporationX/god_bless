package faang.school.godbless.sprint4.tracking;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class TransportManagementSystem {
    private Map<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void updateLocation(int vehicleId, double latitude, double longitude) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            Location newLocation = new Location(latitude, longitude);
            vehicle.setLocation(newLocation);
        }
    }

    public void updateStatus(int vehicleId, boolean status) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.setStatus(status);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicle(int vehicleId) {
        return vehicles.get(vehicleId);
    }
}
