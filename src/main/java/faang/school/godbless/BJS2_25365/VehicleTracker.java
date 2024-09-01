package faang.school.godbless.BJS2_25365;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class VehicleTracker {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    public void changeLocation(TransportManagementSystem system) {
        system.getCars().values().forEach(vehicle -> {
            executorService.schedule(() -> {
                vehicle.setLocation(vehicle.getLocation().changeCurrentLocation());
                log.info("Vehicle {} location updated to {}", vehicle.getId(), vehicle.getLocation());
            }, 1 + vehicle.getId(), TimeUnit.SECONDS);
        });
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error in thread: {}", e.getMessage());
        }
    }
}
