package school.faang.gps_tracker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final long SYSTEM_RUN_DURATION_MS = 10000;
    private static final Location INITIAL_LOCATION = new Location(56.3287, 44.002);

    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem system = initializeSystem();
        VehicleTracker tracker = startTracking(system);
        runSystemForDuration(SYSTEM_RUN_DURATION_MS);
        stopTracking(tracker);
        printVehicleInfo(system);
    }

    private static TransportManagementSystem initializeSystem() {
        TransportManagementSystem system = new TransportManagementSystem();
        system.addVehicle(new Vehicle("1", VehicleStatus.FREE, INITIAL_LOCATION));
        system.addVehicle(new Vehicle("2", VehicleStatus.FREE, INITIAL_LOCATION));
        system.addVehicle(new Vehicle("3", VehicleStatus.BUSY, INITIAL_LOCATION));
        return system;
    }

    private static VehicleTracker startTracking(TransportManagementSystem system) {
        VehicleTracker tracker = new VehicleTracker(system);
        tracker.startTracking();
        return tracker;
    }

    private static void runSystemForDuration(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    private static void stopTracking(VehicleTracker tracker) {
        tracker.stopTracking();
        log.info("Vehicle tracking stopped");
    }

    private static void printVehicleInfo(TransportManagementSystem system) {
        log.info(system.getVehicleInfo("1"));
        log.info(system.getVehicleInfo("2"));
        log.info(system.getVehicleInfo("3"));
    }
}
