package faang.school.godbless.BJS2_1649;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final ScheduledExecutorService executor;
    private final TransportManagementSystem transportManagementSystem;

    public VehicleTracker(TransportManagementSystem transportManagementSystem) {
        this.transportManagementSystem = transportManagementSystem;
        executor = Executors.newScheduledThreadPool(transportManagementSystem.size());
    }

    public void startTracking(int vehicleId) {
        Runnable trackVehicle = () -> {
            Vehicle vehicle = transportManagementSystem.getVehicleById(vehicleId)
                    .orElseThrow(() -> new NoSuchElementException("Vehicle not found with ID: " + vehicleId));

            getPrintf("Vehicle with id = %s started to track, current location: ", vehicleId, vehicle);

            updateVehicleLocationAndStatus(vehicle);
            transportManagementSystem.updateVehicle(vehicle);

            getPrintf("Vehicle with id = %s is updated, current location:", vehicleId, vehicle);
        };

        executor.scheduleAtFixedRate(trackVehicle, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        executor.shutdown();
    }

    private void getPrintf(String x, int vehicleId, Vehicle vehicle) {
        System.out.printf(x +
                        "latitude is %.2f, longitude is %.2f and status is %s\n"
                , vehicleId, vehicle.getLocation().latitude(), vehicle.getLocation().longitude(), vehicle.isAvailable());
    }

    private void updateVehicleLocationAndStatus(Vehicle vehicle) {
        Random random = new Random(1337);

        double newLatitude = vehicle.getLocation().latitude() + (random.nextDouble() - 0.5);
        double newLongitude = vehicle.getLocation().longitude() + (random.nextDouble() - 0.5);

        vehicle.setLocation(new Location(newLatitude, newLongitude));
        vehicle.setAvailable(random.nextBoolean());
    }
}
