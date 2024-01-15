package faang.school.godbless.BJS2_1649;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ToString
@EqualsAndHashCode
@Getter
public class TransportManagementSystem {
    private final Map<Integer, Vehicle> vehicleById = new ConcurrentHashMap<>();

    public Optional<Vehicle> getVehicleById(int vehicleId) {
        return Optional.ofNullable(vehicleById.get(vehicleId));
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleById.put(vehicle.getId(), vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleById.put(vehicle.getId(), vehicle);
    }

    public int size () {
        return vehicleById.size();
    }
}