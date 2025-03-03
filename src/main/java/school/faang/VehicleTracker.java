package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class VehicleTracker {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final int TRACKING_INTERVAL_SECONDS = 2;
    private final TransportManagementSystem managementSystem;
    private static final int TIMEOUT_SECONDS = 10;

    public void startTracking(int id) {
        executor.scheduleAtFixedRate(() -> {
            Location newLocation = Location.generateRandomLocation();
            managementSystem.updateVehicleLocation(id, newLocation);
        }, 0, TRACKING_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Not all tasks have been completed on time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination was interrupted.");
            executor.shutdownNow();
        }
    }
}
