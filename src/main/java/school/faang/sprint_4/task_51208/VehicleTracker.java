package school.faang.sprint_4.task_51208;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class VehicleTracker {
    private static final int AWAIT_TIME = 5;

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final int repeatDelay;
    private final TimeUnit timeUnit;

    public void startTracking(Vehicle vehicle) {
        executor.scheduleAtFixedRate(() -> {
            Location location = LocationGenerator.generateRandomLocation();
            vehicle.updateLocation(location);
            log.info("Vehicle {} location updated to {}", vehicle, location);
        }, 0, repeatDelay, timeUnit);
    }

    public void stopTracking() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("Await timed out. Shutting down...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Thread interrupted. Shutting down...");
            executor.shutdownNow();
        }
    }
}
