package faang.school.godbless.concurrency.trackingSystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker(5);

        transportManagementSystem.addVehicle(new Vehicle(1, new Location(0.0, 0.0)));
        transportManagementSystem.addVehicle(new Vehicle(2, new Location(0.0, 0.0)));
        transportManagementSystem.addVehicle(new Vehicle(3, new Location(0.0, 0.0)));
        transportManagementSystem.addVehicle(new Vehicle(4, new Location(0.0, 0.0)));
        transportManagementSystem.addVehicle(new Vehicle(5, new Location(0.0, 0.0)));

        log.info("Starting tracking...");

        transportManagementSystem.getVehiclesInfo().forEach(vehicle -> vehicleTracker.addTrackerToVehicle(vehicle, transportManagementSystem));


        Thread.sleep(30000L);
        vehicleTracker.shutdownTracking();

        log.info("Tracking is over");
    }
}
