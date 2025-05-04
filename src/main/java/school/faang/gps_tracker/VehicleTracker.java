package school.faang.gps_tracker;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    private final TransportManagementSystem system;
    private final ScheduledExecutorService scheduler;
    private final Random random = new Random();

    public VehicleTracker(TransportManagementSystem system) {
        this.system = system;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startTracking() {
        scheduler.scheduleAtFixedRate(() -> system.getAllVehicles().forEach((id, vehicle) -> {

            double latChange = (random.nextDouble() - 0.5) * 0.01;
            double lonChange = (random.nextDouble() - 0.5) * 0.01;

            Location current = vehicle.getLocation();
            Location newLocation = new Location(
                    current.getLatitude() + latChange,
                    current.getLongitude() + lonChange
            );

            system.updateVehicleLocation(id, newLocation);

            if (random.nextInt(5) == 0) {
                VehicleStatus newStatus =
                        VehicleStatus.BUSY == vehicle.getStatus() ? VehicleStatus.FREE : VehicleStatus.BUSY;
                system.updateVehicleStatus(id, newStatus);
            }

            log.info("Detection move: {}", system.getVehicleInfo(id));
        }), 0, 1, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(1, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
