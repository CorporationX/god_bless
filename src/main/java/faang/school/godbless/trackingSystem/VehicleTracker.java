package faang.school.godbless.trackingSystem;

import java.util.concurrent.*;

public class VehicleTracker {
    private final TransportManagementSystem tms;
    private final ScheduledExecutorService executorService;

    public VehicleTracker(TransportManagementSystem tms) {
        this.tms = tms;
        this.executorService = Executors.newScheduledThreadPool(tms.getVehicles().size());
    }

    public void startTracking() {
        for (Vehicle vehicle : tms.getVehicles().values()) {
            executorService.scheduleAtFixedRate(() -> {
                double newLatitude = vehicle.getLocation().getLatitude() + Math.random() * 0.1 - 0.05;
                double newLongitude = vehicle.getLocation().getLongitude() + Math.random() * 0.1 - 0.05;
                Location newLocation = new Location(newLatitude, newLongitude);
                vehicle.updateLocation(newLocation);

                String newStatus = Math.random() < 0.5 ? "Free" : "Busy";
                vehicle.updateStatus(newStatus);

                System.out.println("Updated vehicle " + vehicle.getId() + ": Location = " + newLocation.getLatitude() +
                        ", " + newLocation.getLongitude() + ", Status = " + newStatus);
            }, 0, 5, TimeUnit.SECONDS);
        }
    }

    public void stopTracking() {
        executorService.shutdown();
    }
}
