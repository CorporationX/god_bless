package trackingSystem;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private static final ScheduledExecutorService SERVICE = Executors.newSingleThreadScheduledExecutor();

    public void update(Map<String, Vehicle> vehicles) {
        SERVICE.scheduleAtFixedRate(() -> {
            vehicles.forEach(((string, vehicle) -> {
                vehicle.setLocation(vehicle.getLocation().getNewLocation(
                        vehicle.getLocation().getLatitude() + ThreadLocalRandom.current().nextDouble(),
                        vehicle.getLocation().getLongitude() + ThreadLocalRandom.current().nextDouble()
                ));
                if (vehicle.isStatus()) {
                    vehicle.setStatus(false);
                } else {
                    vehicle.setStatus(true);
                }
            }));
        }, 0, 10, TimeUnit.SECONDS);
    }

    public void shutdown() {
        SERVICE.shutdown();
    }
}
