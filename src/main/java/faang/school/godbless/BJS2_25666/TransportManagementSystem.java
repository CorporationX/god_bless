package faang.school.godbless.BJS2_25666;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class TransportManagementSystem {
    private final Map<Long, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(long vehicleId, Location newLocation) {
        vehicles.computeIfPresent(vehicleId, (id, vehicle) -> {
            vehicle.setLocation(newLocation);
            return vehicle;
        });
    }

    public void updateVehicleStatus(long vehicleId, boolean newStatus) {
        vehicles.computeIfPresent(vehicleId, (id, vehicle) -> {
            vehicle.setStatus(newStatus);
            return vehicle;
        });
    }
    public Vehicle getVehicle(long vehicleId) {
        return vehicles.get(vehicleId);
    }
    public Collection<Vehicle> getAllVehicles() {
        return vehicles.values();
    }
}
