package school.faang.concurrency.tracking_system;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {

    private final Map<String, Vehicle> vehicleMap = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(Vehicle vehicle, Location newLocation) {
        vehicle.updateLocation(newLocation);
    }

    public void updateVehicleStatus(Vehicle vehicle, String newStatus) {
        vehicle.updateStatus(newStatus);
    }

    public String getVehicleInfo(String vehicleId) {
        return vehicleMap.get(vehicleId).toString();
    }

}
