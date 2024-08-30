package faang.school.godbless.trackingsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    private final TransportManagementSystem system;
    private final ScheduledExecutorService scheduler;

    public VehicleTracker(TransportManagementSystem system) {
        this.system = system;
        this.scheduler = Executors.newScheduledThreadPool(4);
    }

    public void startTracking() {
        scheduler.scheduleAtFixedRate(() -> {
            for (Vehicle vehicle : system.getVehicles().values()) {
                system.updateVehicleLocation(vehicle);
                system.updateVehicleStatus(vehicle);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        scheduler.shutdown();
        try {
            if (scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error in thread: {}", e.getMessage());
        }
    }
}