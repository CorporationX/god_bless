package school.faang.sprint_4.tracking_system;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker  {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void trackVehicle() {
        TransportManagementSystem.vehicles.forEach((key, value) -> scheduler.scheduleAtFixedRate(() ->
                TransportManagementSystem
                        .getVehicleInfo(key), 0, 5, TimeUnit.SECONDS));
    }
}
