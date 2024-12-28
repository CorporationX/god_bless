package school.faang.task51217;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int START_POSITION = 0;
    private static final int TIMEOUT = 20;
    private static final int COUNT_VEHICLES = 10;

    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        VehicleTracker tracker = new VehicleTracker();
        tracker.startCheckLocationAndStatus(service, system);

        IntStream.range(0, COUNT_VEHICLES)
                .forEach(i -> system.addVehicle(
                        new Vehicle(i, Status.FREE, new Location(START_POSITION, START_POSITION))
                ));

        try {
            if (!service.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                service.shutdown();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message", e);
        }
    }
}
