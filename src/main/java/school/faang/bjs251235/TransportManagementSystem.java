package school.faang.bjs251235;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
public class TransportManagementSystem {
    private final Map<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        vehicles.get(vehicleId)
                .updateLocation(newLocation);
    }

    public Vehicle getVehicleInfo(String vehicleId) {
        return vehicles.get(vehicleId);
    }
}