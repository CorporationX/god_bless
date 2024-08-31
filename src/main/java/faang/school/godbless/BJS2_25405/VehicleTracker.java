package faang.school.godbless.BJS2_25405;

import lombok.AllArgsConstructor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class VehicleTracker {

    private TransportManagementSystem transportManagement;
    private ScheduledExecutorService scheduledExecutor;

    public void startTracking() {
        transportManagement.forEachValues((vehicle -> scheduledExecutor.scheduleWithFixedDelay(
                () -> tracking(vehicle), 0, 2, TimeUnit.SECONDS)));
    }

    private void tracking(Vehicle vehicle) {
        try {
            Location location = vehicle.getLocation();
            System.out.printf("Tracking vehicle %s. Her location: %s%n", vehicle.getId(), location);

            boolean isNewStatus = ThreadLocalRandom.current().nextInt(1, 11) >= 8;
            if (isNewStatus) {
                vehicle.nextStatus();
                if (vehicle.getStatus() == Status.FREE) {
                    System.out.printf("The vehicle %d is free%n", vehicle.getId());
                    Thread.sleep(5000L);
                }
            }

            vehicle.setLocation(location.nextLocation());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
