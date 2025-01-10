package school.faang.bjs251235;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class VehicleTracker {
    private static final int AWAIT_TIME = 5;
    private final int repeatDelay;
    private final TimeUnit timeUnit;

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public void startTracker(Vehicle vehicle) {
        service.scheduleAtFixedRate(() -> {
            Location location = LocationGenerator.generateRandomLocation();

            vehicle.updateLocation(location);
            log.info("The location of {} has updated to {}", vehicle, location);
        }, 0, repeatDelay, timeUnit);
    }

    public void stopTracker() {
        service.shutdown();
        try {
            if (!service.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The tread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}