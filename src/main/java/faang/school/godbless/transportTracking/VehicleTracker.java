package faang.school.godbless.transportTracking;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final TransportManagementSystem transportManagementSystem;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Random random = new Random();

    public VehicleTracker(TransportManagementSystem transportManagementSystem) {
        this.transportManagementSystem = transportManagementSystem;
        this.scheduledExecutorService =  Executors.newScheduledThreadPool(transportManagementSystem.getVehicles().size());
    }

    private void changeVehicleData(Vehicle vehicle) {
        Location currentLocation = vehicle.getLocation();
        double maxLatitude = currentLocation.getLatitude() + 100;
        double minLatitude = currentLocation.getLatitude() - 100;
        double maxLongitude = currentLocation.getLongitude() + 100;
        double minLongitude = currentLocation.getLongitude() - 100;
        vehicle.setLocation(new Location(
                random.nextDouble(maxLatitude - minLatitude + 1) + minLatitude,
                random.nextDouble(maxLongitude - minLongitude + 1) + minLongitude));
        if (vehicle.getStatus().equals("available")) {
            vehicle.setStatus("unavailable");
        } else {
            vehicle.setStatus("available");
        }
    }

    public void track() {
        for (Vehicle vehicle : transportManagementSystem.getVehicles().values()) {
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                System.out.println("Tracking vehicle: " + vehicle);
                changeVehicleData(vehicle);
            }, 0, 5, TimeUnit.SECONDS);
        }
    }

    public void stop() {
        scheduledExecutorService.shutdown();
        try {
            if (!scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
