package school.faang.sprint_4.task_51208;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final Map<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(@NonNull Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(int vehicleId,
                                      @NonNull Location newLocation) {
        vehicles.get(vehicleId)
                .updateLocation(newLocation);
    }

    public void getVehicleInfo(int vehicleId) {
        vehicles.get(vehicleId);
    }
}
