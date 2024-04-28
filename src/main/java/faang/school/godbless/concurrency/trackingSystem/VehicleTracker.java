package faang.school.godbless.concurrency.trackingSystem;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class VehicleTracker {
    static int NEW_LOCATION_MAX_DIF = 5; //максимальное смещение по ширине/долготе от предыдущего положения (в метрах)
    static int TRACKING_DELAY = 3; //В секундах
    ScheduledExecutorService scheduledTracker;
    List<ScheduledFuture<?>> trackingTasks = new ArrayList<>();

    public VehicleTracker(int trackersAmount) {
        scheduledTracker = Executors.newScheduledThreadPool(trackersAmount);
    }

    public void addTrackerToVehicle(Vehicle vehicle, TransportManagementSystem transportManagementSystem) {
        var trackingTask = scheduledTracker.scheduleAtFixedRate(() -> {
            double newLatitude = vehicle.getCurrentLocation().latitude() + ThreadLocalRandom.current().nextDouble(0, NEW_LOCATION_MAX_DIF);
            double newLongitude = vehicle.getCurrentLocation().longitude() + ThreadLocalRandom.current().nextDouble(0, NEW_LOCATION_MAX_DIF);
            var newLocation = new Location(newLatitude, newLongitude);

            transportManagementSystem.updateVehicleLocation(vehicle.getId(), newLocation);
        }, TRACKING_DELAY, TRACKING_DELAY, TimeUnit.SECONDS);

        trackingTasks.add(trackingTask);
    }

    public void shutdownTracking() {
        trackingTasks.forEach(task -> task.cancel(true));
        scheduledTracker.shutdown();
    }
}
