package faang.school.godbless.BJS2_25389;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final ConcurrentHashMap<Long, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        long id = vehicle.getId();
        vehicles.put(id, vehicle);
    }

    public void showAllTransport() {
        vehicles.forEach((key, value) -> System.out.println(value));
    }
}
