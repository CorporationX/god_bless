package faang.school.godbless.BJS2_25666;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(
                new Vehicle(1, true, new Location(1, 1)),
                new Vehicle(2, true, new Location(2, 2)),
                new Vehicle(3, true, new Location(3, 3)),
                new Vehicle(4, true, new Location(4, 4)),
                new Vehicle(5, true, new Location(5, 5))
        );

        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        vehicles.forEach(transportManagementSystem::addVehicle);

        VehicleTracker vehicleTracker = new VehicleTracker(vehicles.size());
        vehicleTracker.startTracking(transportManagementSystem);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            vehicleTracker.stopTracking();
        }
    }
}
