package faang.school.godbless.location;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker(5);
        Vehicle bike = new Vehicle(1, StatusVehicle.FREE, new Location(12d, 13d));
        Vehicle taxi = new Vehicle(2, StatusVehicle.FREE, new Location(12d, 13d));
        Vehicle truck = new Vehicle(3, StatusVehicle.FREE, new Location(12d, 13d));
        transportManagementSystem.addVehicle(bike);
        transportManagementSystem.addVehicle(taxi);
        transportManagementSystem.addVehicle(truck);

        vehicleTracker.addTrackerToVehicle(bike, transportManagementSystem);
        vehicleTracker.addTrackerToVehicle(taxi, transportManagementSystem);
        vehicleTracker.addTrackerToVehicle(truck, transportManagementSystem);

        TimeUnit.SECONDS.sleep(7);
        vehicleTracker.shutdownTracking();

        log.info("Tracking is over");
    }
}
