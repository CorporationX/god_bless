package faang.school.godbless.sprint5.multithreading_conc.task8_tracking;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {

    private final TransportManagementSystem transportManagementSystem;

    private final ScheduledExecutorService scheduledExecutor;

    public VehicleTracker(TransportManagementSystem transportManagementSystem) {
        this.transportManagementSystem = transportManagementSystem;
        scheduledExecutor = Executors.newScheduledThreadPool(transportManagementSystem.getVehicles().size());
    }

    @SneakyThrows
    public void trackingVehicle() {
        for (int i = 0; i < transportManagementSystem.getVehicles().size(); i++) {
            int finalI = i;
            scheduledExecutor.scheduleAtFixedRate(() -> transportManagementSystem.updateVehicleLocation(finalI), 5, 5, TimeUnit.SECONDS);
        }
    }
}
