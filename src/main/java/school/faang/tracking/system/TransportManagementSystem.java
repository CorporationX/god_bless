package school.faang.tracking.system;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TransportManagementSystem {
    private final ConcurrentMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();
    private final VehicleTracker tracker = new VehicleTracker(this);

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
        tracker.track(vehicle.getId());
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        vehicles.get(vehicleId).updateLocation(newLocation);
        System.out.println(vehicleId + " изменил свои координаты: " + newLocation);
    }

    public void updateVehicleStatus(String vehicleId, Status newStatus) {
        vehicles.get(vehicleId).updateStatus(newStatus);
        System.out.println(vehicleId + " изменил свой статус: " + newStatus);
    }

    public VehicleInfo getVehicleInfo(String vehicleId) {
        return vehicles.get(vehicleId).getVehicleInfo();
    }
}
