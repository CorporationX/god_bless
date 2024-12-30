package school.faang.sprint_4.task_51208;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_OF_VEHICLES = 10;
    private static final int VEHICLE_LOCATION_UPDATE_DELAY = 5;
    private static final int APP_WORKING_TIME = 10000;

    public static void main(String[] args) {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();

        List<VehicleTracker> vehicleTrackers = new ArrayList<>();
        IntStream.rangeClosed(1, NUMBER_OF_VEHICLES)
                .mapToObj(id -> new Vehicle(id, LocationGenerator.generateRandomLocation()))
                .forEach((vehicle) -> {
                    transportManagementSystem.addVehicle(vehicle);
                    VehicleTracker vehicleTracker = new VehicleTracker(VEHICLE_LOCATION_UPDATE_DELAY, TimeUnit.SECONDS);
                    vehicleTracker.startTracking(vehicle);
                    vehicleTrackers.add(vehicleTracker);
                });

        try {
            Thread.sleep(APP_WORKING_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            vehicleTrackers.forEach(VehicleTracker::stopTracking);
        }
    }
}
