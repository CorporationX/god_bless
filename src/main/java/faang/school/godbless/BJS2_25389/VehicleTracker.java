package faang.school.godbless.BJS2_25389;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class VehicleTracker {
    private static final long UPDATE_PERIOD = 4;

    private final Vehicle vehicle;
    private final ScheduledExecutorService executor;
    private final Random random = new Random();

    private void updateMetrics() {
        Location oldLocation = vehicle.getLocation();
        double newLat = oldLocation.getLat() + random.nextDouble(0.02) - 0.01;
        double newLon = oldLocation.getLon() + random.nextDouble(0.02) - 0.01;
        vehicle.setLocation(new Location(newLat, newLon));

        String[] vehicleStatus = {"WITH_PASSENGER", "WITHOUT_PASSENGER"};
        vehicle.setStatus(vehicleStatus[random.nextInt(2)]);
    }

    public void startTracking() {
        executor.scheduleAtFixedRate(this::updateMetrics, 0, UPDATE_PERIOD, TimeUnit.SECONDS);
    }
}
