package faang.school.godbless.tracking_system;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VehicleTracker vehicleTracker = new VehicleTracker();

        getVehicles().forEach(vehicle -> vehicleTracker.getTransportManagementSystem().addVehicle(vehicle));

        vehicleTracker.updateVehicleStatuses();
    }

    private static List<Vehicle> getVehicles() {
        return List.of(
                new Vehicle(1, VehicleStatus.FREE, new Location(0, 0)),
                new Vehicle(2, VehicleStatus.FREE, new Location(0, 0)),
                new Vehicle(3, VehicleStatus.FREE, new Location(0, 0))
        );
    }
}
