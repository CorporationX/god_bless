package faang.school.godbless.TrackingSystem;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    @Getter
    private TransportManagementSystem transportManagementSystem = new TransportManagementSystem();

    public void startTracking() {

        executor.scheduleAtFixedRate(() -> {
            for (int i = 1; i <= getTransportManagementSystem().getTransportsById().size(); i++) {
                Vehicle tempVehicle = getTransportManagementSystem().getTransportsById().get(i);
                tempVehicle.setLocation(tempVehicle.getLocation().getLatitude() + 10, tempVehicle.getLocation().getLongitude() + 20);
                transportManagementSystem.printTransports();
            }
        }, 0,5, TimeUnit.SECONDS);

    }

}
