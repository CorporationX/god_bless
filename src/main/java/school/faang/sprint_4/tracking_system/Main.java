package school.faang.sprint_4.tracking_system;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;


public class Main {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
    private static final Random random = new Random();

    public static void main(String[] args) {
        Location location = new Location(23, 34);
        Vehicle vehicle1 = new Vehicle("V001", "ACTIVE", new Location(55.7558, 37.6176));
        Vehicle vehicle2 = new Vehicle("V002", "IDLE", new Location(59.9343, 30.3351));
        Vehicle vehicle3 = new Vehicle("V003", "IN_TRANSIT", new Location(48.8566, 2.3522));
        TransportManagementSystem.addVehicle(vehicle1);
        TransportManagementSystem.addVehicle(vehicle2);
        TransportManagementSystem.addVehicle(vehicle3);
        VehicleTracker vehicleTracker = new VehicleTracker();
        vehicleTracker.trackVehicle();

        scheduleLocationUpdates("V001");
        scheduleLocationUpdates("V002");
        scheduleLocationUpdates("V003");


        TransportManagementSystem.updateVehicle("V001", new Location(56.0, 38.0));
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            TransportManagementSystem.getVehicleInfo("V001");
            TransportManagementSystem.getVehicleInfo("V002");
            TransportManagementSystem.getVehicleInfo("V003");
        }, 5, 10, TimeUnit.SECONDS);
    }

    private static void scheduleLocationUpdates(String vehicleId) {
        scheduler.scheduleAtFixedRate(() -> {
            Location newLocation = generateRandomLocation();
            TransportManagementSystem.updateVehicle(vehicleId, newLocation);
        }, 0, 5, TimeUnit.SECONDS);
    }

    private static Location generateRandomLocation() {
        double lat = 50 + random.nextDouble() * 10;
        double lon = 20 + random.nextDouble() * 20;
        return new Location(lat, lon);
    }

}
