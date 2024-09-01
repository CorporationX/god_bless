package tracking;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private static final String NO_VEHICLE = "Vehicle not in manager!";
    private final Map<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(@NonNull Vehicle vehicle) {
        if (vehicles.containsKey(vehicle.getId())) {
            throw new IllegalArgumentException("Vehicle already added to manager");
        }
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void removeVehicle(int id) {
        if (!vehicles.containsKey(id)) {
            throw new IllegalArgumentException(NO_VEHICLE);
        }
        vehicles.remove(id);
    }

    public void updateVehicleStatus(int id, StatusState status) {
        if (!vehicles.containsKey(id)) {
            throw new IllegalArgumentException(NO_VEHICLE);
        }
        vehicles.get(id).setStatus(status);
    }

    public void updateVehicleLocation(int id, @NonNull Location location) {
        if (!vehicles.containsKey(id)) {
            throw new IllegalArgumentException(NO_VEHICLE);
        }
        vehicles.get(id).setCurrentLocation(location);
    }
}
