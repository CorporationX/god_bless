package derschrank.sprint04.task22.bjstwo_51227;

import derschrank.sprint04.task22.bjstwo_51227.units.Location;
import derschrank.sprint04.task22.bjstwo_51227.units.Status;
import derschrank.sprint04.task22.bjstwo_51227.units.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem implements Management {
    private final Map<String, Vehicle> vehicles;

    public TransportManagementSystem() {
        vehicles = new ConcurrentHashMap<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    @Override
    public Location getVehicleLocation(String vehicleId) {
        return vehicles.get(vehicleId).getLocation();
    }

    @Override
    public Status getVehicleStatus(String vehicleId) {
        return vehicles.get(vehicleId).getStatus();
    }

    @Override
    public boolean isThereVehicle(String vehicleId) {
        return vehicles.get(vehicleId) != null;
    }

    @Override
    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        vehicles.computeIfPresent(vehicleId, (id, value) -> {
            value.updateLocation(newLocation);
            return value;
        });
    }

    @Override
    public void updateVehicleStatus(String vehicleId, Status newStatus) {
        vehicles.computeIfPresent(vehicleId, (id, value) -> {
            value.updateStatus(newStatus);
            return value;
        });
    }

    @Override
    public String getVehicleInfo(String vehicleId) {
        String resultInfo = "There is not the vehicle: " + vehicleId;
        Optional<Vehicle> vehicleOpt = Optional.ofNullable(vehicles.get(vehicleId));
        if (vehicleOpt.isPresent()) {
            resultInfo = vehicleOpt.get().toString();
        }
        return resultInfo;
    }
}
