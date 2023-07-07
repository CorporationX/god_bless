package faang.school.godbless.TrackingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class VehicleTracker {
    private TransportManagementSystem transportManagementSystem;

    public void track() {
        transportManagementSystem.getVehicles().forEach((id, vehicle) -> {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(() -> {
                double newLat = vehicle.getLocation().getLatitude() + ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
                double newLong = vehicle.getLocation().getLongitude() + ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
                transportManagementSystem.updateVehicleData(vehicle.getId(), new Location(newLat, newLong));
                transportManagementSystem.printVehicleData(vehicle.getId());
            }, 0, 3, TimeUnit.SECONDS);
        });
    }
}
