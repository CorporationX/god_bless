package faang.school.godbless.transportTracking;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {
    private final Map<Location, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getLocation(), vehicle);
    }
}
