package faang.school;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        TransportManagementSystem transportSystem = new TransportManagementSystem();

        Vehicle vehicle1 = new Vehicle(1, true, new Location(37.7749, -122.4194));
        transportSystem.addVehicle(vehicle1);

        VehicleTracker tracker = new VehicleTracker(transportSystem);
        tracker.startTracking(1);
        executorService.execute(() -> {
            while (true) {
                System.out.println(vehicle1.getCurrentLocation());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Bom");
                }
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tracker.stopTracking();
        executorService.shutdownNow();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }
}
