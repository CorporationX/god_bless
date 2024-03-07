package faang.school.godbless.trackingsys;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {

    private Map<Long, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        validateAddVehicle(vehicle);
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        validateUpdateVehicle(vehicle);
        vehicles.put(vehicle.getId(), vehicle);
    }

    public Optional<Vehicle> getVehicleById(long id) {
        return Optional.ofNullable(vehicles.get(id));
    }

    private void validateAddVehicle(Vehicle vehicle) {
        validateVehicleIsNull(vehicle);
        if (vehicles.containsKey(vehicle.getId())) {
            throw new IllegalArgumentException("Vehicle already exist");
        }
    }

    private void validateUpdateVehicle(Vehicle vehicle) {
        validateVehicleIsNull(vehicle);
        if (!vehicles.containsKey(vehicle.getId())) {
            throw new IllegalArgumentException("Vehicle does not exist");
        }
    }

    private void validateVehicleIsNull(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle can't be null");
        }
    }
}
