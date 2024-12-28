package school.faang.task51217;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class VehicleTracker {
    private static final int MAX_LATITUDE = 90;
    private static final int MIN_LATITUDE = -90;
    private static final int MAX_LONGITUDE = 180;
    private static final int MIN_LONGITUDE = 0;

    public void startCheckLocationAndStatus(ScheduledExecutorService service,
                                            TransportManagementSystem managementSystem) {
        service.scheduleAtFixedRate(() -> {
            managementSystem.getVehicles().entrySet().stream()
                    .flatMap(entry -> entry.getValue().parallelStream())
                    .forEach(vehicle ->
                            managementSystem.updateVehicleLocation(vehicle, new Location(
                                    ThreadLocalRandom.current().nextDouble(MIN_LATITUDE, MAX_LATITUDE),
                                    ThreadLocalRandom.current().nextDouble(MIN_LONGITUDE, MAX_LONGITUDE))));
            log.info(managementSystem.getVehicles().toString());
        }, 0, 5, TimeUnit.SECONDS);
    }
}
