package school.faang.gps_tracker;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    private final TransportManagementSystem system;
    private final ScheduledExecutorService scheduler;
    private final Map<String, ScheduledFuture<?>> trackingTasks = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public VehicleTracker(TransportManagementSystem system, int threadPoolSize) {
        this.system = system;
        this.scheduler = Executors.newScheduledThreadPool(threadPoolSize);
    }

    public void startTracking(String vehicleId) {
        if (trackingTasks.containsKey(vehicleId)) {
            log.warn("Vehicle {} is already being tracked.", vehicleId);
            return;
        }


        Runnable task = () -> {
            Vehicle vehicle = system.getAllVehicles().get(vehicleId);
            if (vehicle == null) {
                log.warn("Vehicle {} not found", vehicleId);
                return;
            }

            double latChange = (random.nextDouble() - 0.5) * 0.01;
            double lonChange = (random.nextDouble() - 0.5) * 0.01;

            Location current = vehicle.getLocation();
            Location newLocation = new Location(
                    current.getLatitude() + latChange,
                    current.getLongitude() + lonChange
            );

            system.updateVehicleLocation(vehicleId, newLocation);

            if (random.nextInt(5) == 0) {
                VehicleStatus newStatus = vehicle.getStatus() == VehicleStatus.BUSY
                        ? VehicleStatus.FREE
                        : VehicleStatus.BUSY;
                system.updateVehicleStatus(vehicleId, newStatus);
            }

            log.info("Tracking vehicle {}: {}", vehicleId, system.getVehicleInfo(vehicleId));
        };

        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        trackingTasks.put(vehicleId, future);
    }

    public void stopAllTracking() {
        trackingTasks.values().forEach(future -> future.cancel(true));
        trackingTasks.clear();
        scheduler.shutdown();
        log.info("All tracking tasks stopped.");
    }
}
