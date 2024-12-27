package school.faang.task51217;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Slf4j
public class TransportManagementSystem {
    private final Map<Status, List<Vehicle>> vehicles = new ConcurrentHashMap<>(Map.of(
            Status.FREE, new CopyOnWriteArrayList<>(),
            Status.BUSY, new CopyOnWriteArrayList<>()
    ));

    private void validateVehicle(Vehicle vehicle) {
        Objects.requireNonNull(vehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        validateVehicle(vehicle);

        List<Vehicle> vehicleList = vehicles.get(vehicle.getStatus());

        if (vehicleList.contains(vehicle)) {
            throw new IllegalArgumentException(String.format("%s уже содержится в системе", vehicle));
        }

        vehicleList.add(vehicle);

        log.info("{} добавлено в систему", vehicle);
    }

    public void updateVehicleLocation(Vehicle vehicle, Location location) {
        validateVehicle(vehicle);

        Vehicle oldVehicle = getVehicleInfo(vehicle.getId());

        oldVehicle.updateLocation(location);
    }

    public Vehicle getVehicleInfo(int id) {
        Optional<Vehicle> vehicle = vehicles.entrySet().stream()
                .flatMap(entry -> entry.getValue().parallelStream())
                .filter(oldVehicle -> oldVehicle.getId() == id)
                .findFirst();

        if (vehicle.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s не содержится в системе", vehicle));
        } else {
            log.info("Информация транспортного средства: {}", vehicle.get());
            return vehicle.get();
        }
    }
}