package faang.school.godbless.location;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {

    private static final int PERIOD = 3;

    private final ScheduledExecutorService executorService;

    public VehicleTracker(int trackersAmount) {
        executorService = Executors.newScheduledThreadPool(trackersAmount);
    }

    public void addTrackerToVehicle(Vehicle vehicle, TransportManagementSystem transportManagementSystem) {
        executorService.scheduleAtFixedRate(() -> {
            Location oldLocation = vehicle.getLocation();
            double newLatitude = oldLocation.getLatitude() + ThreadLocalRandom.current().nextDouble(0.001, 0.01);
            double newLongitude = oldLocation.getLongitude() + ThreadLocalRandom.current().nextDouble(0.001, 0.01);
            var newLocation = new Location(newLatitude, newLongitude);
            var newStatus = StatusVehicle.randomStatusVehicle();
            log.info("Updated car with id {}, new statuse: {}, new location: {}", vehicle.getId(), newStatus, newLocation);
            transportManagementSystem.addVehicle(new Vehicle(vehicle.getId(), newStatus, newLocation));
        }, 0, PERIOD, TimeUnit.SECONDS);
    }

    public void shutdownTracking() {
        executorService.schedule(executorService::shutdown, 1, TimeUnit.SECONDS);
    }
}
