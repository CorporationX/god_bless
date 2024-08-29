package tracking.system;

import lombok.Getter;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {
    private final Map<Integer, Vehicle> vehicleMap = new ConcurrentHashMap<>();

    public void setVehicle(Vehicle vehicle) {
        this.vehicleMap.put(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicleById(int id) {
        if (!this.vehicleMap.containsKey(id)) {
            throw new RuntimeException("Не найдена машина с id: " + id);
        }

        return this.vehicleMap.get(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        Location location = vehicle.getLocation();
        Random random = new Random();

        Location newLocation = new Location(
            location.getLatitude() + random.nextInt(-100, 100),
            location.getLongitude() + random.nextInt(-100, 100)
        );

        Status newStatus = random.nextBoolean() ? Status.BUSY : Status.FREE;

        vehicle.setLocation(newLocation);
        vehicle.setStatus(newStatus);
    }
}
