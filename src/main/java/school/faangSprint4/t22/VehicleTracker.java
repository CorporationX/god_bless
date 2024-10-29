package school.faangSprint4.t22;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final TransportManagementSystem tms;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Random random = new Random();

    public VehicleTracker(TransportManagementSystem tms, int maxVehicles) {
        this.tms = tms;
    }

    public void startTrackingMultiple(Map<String, Integer> vehicleIntervals) {
        for (Map.Entry<String, Integer> entry : vehicleIntervals.entrySet()) {
            startTracking(entry.getKey(), entry.getValue());
        }
    }

    public void startTracking(String vehicleId, int intervalSeconds) {
        scheduler.scheduleAtFixedRate(() -> {
            Location currentLocation = tms.getVehicleInfo(vehicleId).getLocation();
            Location newLocation = simulateMovement(currentLocation);
            tms.updateVehicleLocation(vehicleId, newLocation);
            System.out.println("Updated location for vehicle " + vehicleId + ": " + newLocation);
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    private Location simulateMovement(Location current) {
        double newLat = current.latitude() + (random.nextDouble() - 0.5) * 0.001;
        double newLon = current.longitude() + (random.nextDouble() - 0.5) * 0.001;
        return new Location(newLat, newLon);
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}