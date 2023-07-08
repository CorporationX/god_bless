package faang.school;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class VehicleTracker {
    @NonNull
    private TransportManagementSystem transportSystem;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void startTracking(int vehicleId) {
        var vehicle = transportSystem.getVehicle(vehicleId);
        executor.scheduleAtFixedRate(
                () -> {
                    double updatedLatitude = vehicle.getCurrentLocation().getLatitude() + ThreadLocalRandom.current().nextDouble(10, 30);
                    double updatedLongitude = vehicle.getCurrentLocation().getLongitude() + ThreadLocalRandom.current().nextDouble(10, 30);
                    vehicle.updateLocation(new Location(updatedLatitude, updatedLongitude));
                }, 0, 3, TimeUnit.SECONDS
        );
    }

    public void stopTracking() {
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
