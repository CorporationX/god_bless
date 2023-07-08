package faang.school;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateStatus(int vehicleId, boolean status) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateStatus(status);
        }
    }

    public void updateLocation(int vehicleId, Location location) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateLocation(location);
        }
    }

    public Vehicle getVehicle(int vehicleId) {
        return vehicles.get(vehicleId);
    }
}
