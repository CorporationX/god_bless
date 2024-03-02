package faang.school.godbless.trackingsys;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class VehicleTracker {

    private TransportManagementSystem managementSystem;
    private final ScheduledExecutorService EXECUTOR_SERVICE;

    public VehicleTracker(TransportManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
        EXECUTOR_SERVICE = Executors.newScheduledThreadPool(managementSystem.getVehicles().size());
    }

    public void startTracking() {
        managementSystem.getVehicles().values().forEach(this::pushTrackTask);
    }

    private void pushTrackTask(Vehicle vehicle) {
        EXECUTOR_SERVICE.scheduleAtFixedRate(vehicle::checkCondition, 0, 3, TimeUnit.SECONDS);
    }
}
