package tracking;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    private static final int POOL_SIZE = 10;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);

    public void updateVehicle(@NonNull TransportManagementSystem manager, @NonNull Vehicle vehicle) {
        Runnable task = () -> {
            if (vehicle.getStatus() == StatusState.BUSY) {
                double newLat = vehicle.getCurrentLocation().getLatitude() +
                        (ThreadLocalRandom.current().nextDouble(0.002) - 0.001);
                double newLong = vehicle.getCurrentLocation().getLongitude() +
                        (ThreadLocalRandom.current().nextDouble(0.002) - 0.001);
                manager.updateVehicleLocation(vehicle.getId(), new Location(newLat, newLong));
                if (ThreadLocalRandom.current().nextInt(100) > 80) {
                    manager.updateVehicleStatus(vehicle.getId(), StatusState.FREE);
                }
            } else {
                if (ThreadLocalRandom.current().nextInt(100) > 20) {
                    manager.updateVehicleStatus(vehicle.getId(), StatusState.BUSY);
                }
            }
        };
        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

    }

    public void shutdown() throws InterruptedException {
        executor.schedule(executor::shutdown, 30, TimeUnit.SECONDS);
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            log.info("Finished");
        } else {
            log.error("Time out");
        }
    }
}
