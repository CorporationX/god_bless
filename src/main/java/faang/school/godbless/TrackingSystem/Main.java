package faang.school.godbless.TrackingSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VehicleTracker vehicleTracker = new VehicleTracker();
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle = new Vehicle(1, false, new Location(5,3));
        vehicles.add(vehicle);
        Vehicle vehicle2 = new Vehicle(2, false, new Location(3,2));
        vehicles.add(vehicle2);
        Vehicle vehicle3 = new Vehicle(3, false, new Location(6,7));
        vehicles.add(vehicle3);
        Vehicle vehicle4 = new Vehicle(4, true, new Location(4,5));
        vehicles.add(vehicle4);

        vehicles.forEach(vehicleTracker::addTransport);

        vehicleTracker.startTracking();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
