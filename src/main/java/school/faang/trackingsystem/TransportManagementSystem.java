package school.faang.trackingsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private VehicleTracker tracker = new VehicleTracker();
    private Map<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void start() {
        vehicles.values().forEach(vehicle -> tracker.trackVehicle(vehicle));
    }

    public void stop() {
        tracker.shutdown();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(String.valueOf(vehicle.getId()), vehicle);
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        vehicles.get(vehicleId).updateLocation(newLocation);
    }

    public Vehicle getVehicleInfo(String vehicleId) {
        return vehicles.get(vehicleId);
    }
}
