package faang.school.godbless.BJS2_25666;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final ScheduledExecutorService scheduler;

    public VehicleTracker(int countVehicles) {
        this.scheduler = Executors.newScheduledThreadPool(countVehicles);
    }

    public void startTracking(TransportManagementSystem transportManagementSystem) {
        transportManagementSystem.getAllVehicles().forEach(vehicle -> scheduler.scheduleAtFixedRate(() -> {
            double newLatitude = vehicle.getLocation().latitude() + (Math.random() - 0.5) * 0.01;
            double newLongitude = vehicle.getLocation().longitude() + (Math.random() - 0.5) * 0.01;
            Location newLocation = new Location(newLatitude, newLongitude);

            transportManagementSystem.updateVehicleLocation(vehicle.getId(), newLocation);

            boolean newStatus = Math.random() > 0.5;

            transportManagementSystem.updateVehicleStatus(vehicle.getId(), newStatus);

            System.out.println(transportManagementSystem.getVehicle(vehicle.getId()));
        }, 0, 5, TimeUnit.SECONDS));
    }

    public void stopTracking() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
