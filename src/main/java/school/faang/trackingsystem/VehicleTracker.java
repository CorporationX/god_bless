package school.faang.trackingsystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private final TransportManagementSystem transportSystem;

    public VehicleTracker(TransportManagementSystem transportSystem) {
        this.transportSystem = transportSystem;
    }

    public void startTracking() {
        scheduler.scheduleAtFixedRate(() -> {
            transportSystem.getVehicleInfo("vehicle1");
            System.out.println("Tracking vehicles...");
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        scheduler.shutdown();
    }
}
