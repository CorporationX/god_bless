package school.faang;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class VehicleTracker {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final int TRACKING_INTERVAL_SECONDS = 2;
    private final TransportManagementSystem managementSystem;

    public void startTracking(int id) {
        executor.scheduleAtFixedRate(() -> {
            Location newLocation = Location.generateRandomLocation();
            managementSystem.updateVehicleLocation(id, newLocation);
        }, 0, TRACKING_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        executor.shutdownNow();
    }
}
