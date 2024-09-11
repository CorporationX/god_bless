package faang.school.godbless.tracking;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {

    private final long FIVE = 5L;
    private final long AWAITING = 1000L;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
    private final ThreadLocalRandom GREAT_RANDOM = ThreadLocalRandom.current();
    private ScheduledExecutorService executorService;

    public void initTrackingSystem() {
        executorService = Executors.newScheduledThreadPool(vehicles.size());

        Location initLocation = new Location(0, 0);

        vehicles.forEach(vehicle -> {
            vehicle.setStatus(1);
            transportManagementSystem.addVehicleOnLocationMap(initLocation, vehicle);
        });

        transportManagementSystem.printVehicleLocationInfo();
    }

    public void startTrackingSystem() {
        vehicles.forEach(vehicle -> executorService.scheduleAtFixedRate(() -> {
            Location newLocation = getNewLocationForVehicle(vehicle);
            transportManagementSystem.updateVehicleOnLocationMap(newLocation, vehicle);
        }, 0, FIVE, TimeUnit.SECONDS));
    }

    public void stopTrackingSystem() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(AWAITING, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Location getNewLocationForVehicle(Vehicle vehicle) {
        //0 - old location minus, 1 old location plus
        int coinFlip = GREAT_RANDOM.nextInt(2);
        int deltaPosition = GREAT_RANDOM.nextInt(3);
        Location oldLocation = vehicle.getLocation();

        return new Location(
                coinFlip == 0 ? oldLocation.getLatitude() - deltaPosition : oldLocation.getLatitude() + deltaPosition,
                coinFlip == 0 ? oldLocation.getLongitude() - deltaPosition : oldLocation.getLongitude() + deltaPosition
        );
    }

    public void getCurrentPositionVehicles() {
        transportManagementSystem.printVehicleLocationInfo();
    }

    public void addVehicle(@NonNull Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
