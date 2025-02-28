package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int PROGRAM_EXECUTION_TIME_MS = 10000;

    public static void main(String[] args) {
        TransportManagementSystem managementSystem = new TransportManagementSystem();
        Vehicle vehicle1 = new Vehicle(1, Status.FREE, Location.generateRandomLocation());
        Vehicle vehicle2 = new Vehicle(2, Status.FREE, Location.generateRandomLocation());
        managementSystem.addVehicle(vehicle1);
        managementSystem.addVehicle(vehicle2);
        VehicleTracker tracker1 = new VehicleTracker(managementSystem);
        VehicleTracker tracker2 = new VehicleTracker(managementSystem);
        tracker1.startTracking(1);
        tracker2.startTracking(2);
        try {
            Thread.sleep(PROGRAM_EXECUTION_TIME_MS);
        } catch (InterruptedException e) {
            log.error("Sleep interrupted.");
            Thread.currentThread().interrupt();
        }
        tracker1.stopTracking();
        tracker2.stopTracking();
    }
}
