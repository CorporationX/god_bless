package faang.school.godbless.location;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final Map<Integer, Vehicle> transportBase = new ConcurrentHashMap<>();

    public void addVehicle(@NonNull Vehicle vehicle) {
        transportBase.put(vehicle.getId(), vehicle);
    }

    public void removeVehicle(int vehicleId) {
        transportBase.remove(vehicleId);
    }
}
