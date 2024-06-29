package faang.school.godbless.tracking_system;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class VehicleTracker {
    private final int THREAD_NUM = 1;
    private final int UPDATE_PERIOD = 3;
    private final TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_NUM);

    public void updateVehicleStatuses() {
        executorService.scheduleWithFixedDelay(() -> {
            transportManagementSystem.updateAllVehicles();
            System.out.println(transportManagementSystem.getIdAndVehicleMap());
        }, UPDATE_PERIOD, UPDATE_PERIOD, TimeUnit.SECONDS);

        executorService.schedule(executorService::shutdown, 30, TimeUnit.SECONDS);
    }
}
