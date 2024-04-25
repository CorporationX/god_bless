package trackingSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private volatile Map<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        checkVehicleIsNotNull(vehicle);
        if (!vehicles.containsKey(vehicle.getNumber())) {
            vehicles.put(vehicle.getNumber(), vehicle);
        } else {
            throw new IllegalArgumentException("Vehicle with this number already exist");
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        checkVehicleIsNotNull(vehicle);
        vehicles.put(vehicle.getNumber(), vehicle);
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    private void checkVehicleIsNotNull(Vehicle vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Vehicle must be exist");
        }
    }
}
