package faang.school.godbless.trackingSystem;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final ConcurrentHashMap<Integer, Vehicle> vehicles;

    public TransportManagementSystem() {
        this.vehicles = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleStatus(int id, String status) {
        Vehicle vehicle = vehicles.get(id);
        if (vehicle != null) {
            vehicle.updateStatus(status);
        }
    }

    public void updateVehicleLocation(int id, Location location) {
        Vehicle vehicle = vehicles.get(id);
        if (vehicle != null) {
            vehicle.updateLocation(location);
        }
    }

    public ConcurrentHashMap<Integer, Vehicle> getVehicles() {
        return vehicles;
    }
}
