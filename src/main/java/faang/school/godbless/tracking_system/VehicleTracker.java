package faang.school.godbless.tracking_system;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class VehicleTracker {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Vehicle vehicle1 = new Vehicle(new Location(55.44, 55.77));
        Vehicle vehicle2 = new Vehicle(new Location(33.23, 67.56));
        Vehicle vehicle3 = new Vehicle(new Location(12.567, 98.98));

        transportManagementSystem.addVehicle(vehicle1);
        transportManagementSystem.addVehicle(vehicle2);
        transportManagementSystem.addVehicle(vehicle3);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            countDownLatch.countDown();
            List<Vehicle> transports = transportManagementSystem.getAllTransports();

            transports.forEach(transport -> executor.execute(() -> {
                log.info("Current transport -> {}", transport.toString());
                Location updatedLocation = new Location(
                        transport.getLocation().getLatitude() + ThreadLocalRandom.current().nextDouble(-0.999, 0.999),
                        transport.getLocation().getLongitude() + ThreadLocalRandom.current().nextDouble(-0.999, 0.999)
                );
                Vehicle updatedVehicle = new Vehicle(transport.getId(), !transport.isBusy(), updatedLocation);
                log.info("Updated transport -> {}", updatedVehicle);
            }));

        }, 0, 5, TimeUnit.SECONDS);

        countDownLatch.await();

        executor.shutdown();
        scheduledExecutorService.shutdown();

    }
}
