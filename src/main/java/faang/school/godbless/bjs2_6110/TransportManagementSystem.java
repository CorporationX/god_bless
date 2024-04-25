package faang.school.godbless.bjs2_6110;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class TransportManagementSystem {

    private final ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        log.info("Add new vehicle with ID {}", vehicle.getId());
        vehicles.putIfAbsent(vehicle.getId(), vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicles.computeIfPresent(vehicle.getId(), (k, v) -> vehicle);
    }

    public void removeVehicle(int vehicleId) {
        log.info("Remove vehicle with ID {}", vehicleId);
        vehicles.remove(vehicleId);
    }
}
