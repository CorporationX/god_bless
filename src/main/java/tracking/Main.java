package tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int VEHICLES_COUNT = 20;
    public static void main(String[] args) throws InterruptedException {
        var vehicles = initVehicles();
        TransportManagementSystem managementSystem = new TransportManagementSystem();
        VehicleTracker tracker = new VehicleTracker();
        vehicles.forEach(managementSystem::addVehicle);
        vehicles.forEach(vehicle -> tracker.updateVehicle(managementSystem, vehicle));
        tracker.shutdown();
    }

    private static List<Vehicle> initVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < VEHICLES_COUNT; i++) {
            double lat = rand.nextDouble() * 180;
            double lon = rand.nextDouble() * 180;
            vehicles.add(new Vehicle(StatusState.FREE, new Location(lat, lon)));
        }
        return vehicles;
    }
}
