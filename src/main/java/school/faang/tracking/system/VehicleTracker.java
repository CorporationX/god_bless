package school.faang.tracking.system;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class VehicleTracker {
    private static final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    private TransportManagementSystem system;

    public void track(String vehicleId) {
        scheduler.scheduleAtFixedRate(() -> {
            VehicleInfo info = getVehicleInfoFromGpsService(vehicleId);
            system.updateVehicleLocation(vehicleId, info.location());
            system.updateVehicleStatus(vehicleId, info.status());
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    private VehicleInfo getVehicleInfoFromGpsService(String vehicleId) {
        return new VehicleInfo(vehicleId, Status.BUSY, Location.generateRandomLocation());
    }

    public static void shutDown() {
        scheduler.shutdown();
    }
}
