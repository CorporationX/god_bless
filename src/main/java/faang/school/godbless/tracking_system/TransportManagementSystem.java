package faang.school.godbless.tracking_system;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class TransportManagementSystem {
    private final Map<Integer, Vehicle> idAndVehicleMap = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        idAndVehicleMap.put(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicle(int vehicleId) {
        if (!idAndVehicleMap.containsKey(vehicleId)) {
            throw new RuntimeException("Could not find Vehicle by id: " + vehicleId);
        }
        return idAndVehicleMap.get(vehicleId);
    }

    public void updateVehicle(Vehicle vehicle) {
        Location location = vehicle.getLocation();

        double differenceLatitude = ThreadLocalRandom.current().nextDouble(0, 10);
        double differenceLongitude = ThreadLocalRandom.current().nextDouble(0, 10);

        Location newLocation = new Location(location.getLatitude() + differenceLatitude,
                location.getLongitude() + differenceLongitude);

        VehicleStatus newStatus = VehicleStatus.getRandomStatus();
        vehicle.setLocation(newLocation);
        vehicle.setVehicleStatus(newStatus);
    }
}
