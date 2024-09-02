package tracking.system;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem managementSystem = new TransportManagementSystem();
        managementSystem.setVehicle(new Vehicle(1, Status.FREE, new Location(0, 0)));
        managementSystem.setVehicle(new Vehicle(2, Status.BUSY, new Location(0, 0)));
        managementSystem.setVehicle(new Vehicle(3, Status.FREE, new Location(0, 0)));

        VehicleTracker vehicleTracker = new VehicleTracker(managementSystem);

        vehicleTracker.startTracking();
    }
}
