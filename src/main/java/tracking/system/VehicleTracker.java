package tracking.system;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class VehicleTracker {
    private final int UPDATE_PERIOD = 3;
    private final int DELAY = 30;

    private final TransportManagementSystem transportManagementSystem;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(
        DELAY / UPDATE_PERIOD
    );

    VehicleTracker(TransportManagementSystem transportManagementSystem) {
        this.transportManagementSystem = transportManagementSystem;
    }

    public void startTracking() {
        this.executorService.scheduleWithFixedDelay(() -> {
            transportManagementSystem.getVehicleMap()
                .values()
                .forEach(transportManagementSystem::updateVehicle);

            System.out.println(transportManagementSystem.getVehicleMap());
        }, 0, UPDATE_PERIOD, TimeUnit.SECONDS);

        this.executorService.schedule(this.executorService::shutdown, DELAY, TimeUnit.SECONDS);
    }
}
