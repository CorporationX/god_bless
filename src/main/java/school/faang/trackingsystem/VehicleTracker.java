package school.faang.trackingsystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int MAP_SIZE = 100;
    private static final double PROBABILITY_OF_BREAKAGE = 0.2;
    private static final Location BASE = new Location(0.0, 0.0);
    private static final int MAX_TIME_TO_WORK = 5;
    private static final int TIME_TO_UPDATE = 1;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

    private Location generateRandomLocation() {
        return new Location(ThreadLocalRandom.current().nextDouble(MAP_SIZE),
                ThreadLocalRandom.current().nextDouble(MAP_SIZE));
    }

    public void trackVehicle(Vehicle vehicle) {
        scheduler.scheduleAtFixedRate(() -> {
            Status newStatus = ThreadLocalRandom.current().nextDouble() > (1 - PROBABILITY_OF_BREAKAGE) ?
                    Status.REPAIR : Status.WORK;
            Location newLocation = newStatus == Status.REPAIR ? BASE : generateRandomLocation();
            vehicle.updateLocation(newLocation);
            vehicle.updateStatus(newStatus);
            System.out.println("Транспортное средство " + vehicle.getId() + " обновило местоположение и статус.");
        }, 0, TIME_TO_UPDATE, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdown();

        try {
            if (scheduler.awaitTermination(MAX_TIME_TO_WORK, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена");
            } else {
                System.out.println("Программа завершена принудительно");
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}