package faang.school.godbless.BJS2_25412;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VehicleTracker {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    private static final TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
    private static final int NUMS_VEHICLES = 10;

    public static void main(String[] args) {

        List<Vehicle> vehicles = IntStream.range(0, NUMS_VEHICLES + 1)
                .mapToObj(i -> new Vehicle(i, Status.FREE, generateRandomLocation()))
                .toList();
        vehicles.forEach(transportManagementSystem::addVehicle);

        Vehicle oneVehicle = transportManagementSystem.getVehicle(3);
        System.out.println(oneVehicle);
        transportManagementSystem.getTransports().values()
                .forEach(vehicle -> executor.scheduleAtFixedRate(() -> {
                    vehicle.setStatus();
                    vehicle.setLocation();
                }, 0, 10, TimeUnit.SECONDS));

        executor.scheduleAtFixedRate(VehicleTracker::printVehicles, 0, 5, TimeUnit.SECONDS);

        sleep(30_000);
        executor.shutdown();
    }

    public synchronized static Locaton generateRandomLocation() {
        double longitude = new Random().nextDouble(55.000000, 56.000000);
        double latitude = new Random().nextDouble(49.000000, 50.000000);
        return new Locaton(longitude, latitude);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void printVehicles() {
        for (var transport : transportManagementSystem.getTransports().values()) {
            System.out.println(transport.getId() + " " + transport.getStatus() + " " + transport.getLocation());
        }
        System.out.println("==============");
    }
}
