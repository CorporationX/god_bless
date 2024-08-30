package faang.school.godbless.trackingsystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();

        Vehicle vehicle1 = new Vehicle(1, new Location(40.7128, -74.0060));
        Vehicle vehicle2 = new Vehicle(2, new Location(34.0522, -118.2437));
        Vehicle vehicle3 = new Vehicle(3, new Location(37.7749, -122.4194));

        system.addVehicle(vehicle1);
        system.addVehicle(vehicle2);
        system.addVehicle(vehicle3);

        VehicleTracker tracker = new VehicleTracker(system);
        tracker.startTracking();
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        tracker.stopTracking();
    }
}