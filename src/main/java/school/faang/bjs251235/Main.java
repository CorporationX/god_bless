package school.faang.bjs251235;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int VEHICLES_AMOUNT = 10;
    private static final int LOCATION_UPDATE_DELAY = 5;
    private static final int PROCESS_TIME = 3000;

    public static void main(String[] args) {
        TransportManagementSystem transportManagement = new TransportManagementSystem();
        List<VehicleTracker> vehicleTrackers = new ArrayList<>();

        IntStream.rangeClosed(1, VEHICLES_AMOUNT)
                .mapToObj(id -> new Vehicle(String.valueOf(id), Status.BUSY,
                        LocationGenerator.generateRandomLocation()))
                .forEach(vehicle -> {
                    transportManagement.addVehicle(vehicle);
                    VehicleTracker vehicleTracker = new VehicleTracker(LOCATION_UPDATE_DELAY, TimeUnit.SECONDS);

                    vehicleTracker.startTracker(vehicle);
                    vehicleTrackers.add(vehicleTracker);
                });

        try {
            Thread.sleep(PROCESS_TIME);
        } catch (InterruptedException e) {
            log.error("The tread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            vehicleTrackers.forEach(VehicleTracker::stopTracker);
        }
    }
}