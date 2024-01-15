package faang.school.godbless.BJS2_1649;

public class Uber {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(new Location(12.5, 11.7), true);
        Vehicle vehicle2 = new Vehicle(new Location(2.5, 151.7), true);
        Vehicle vehicle3 = new Vehicle(new Location(195.5, 17.1), false);
        Vehicle vehicle4 = new Vehicle(new Location(65.99, 15), true);
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        transportManagementSystem.addVehicle(vehicle1);
        transportManagementSystem.addVehicle(vehicle2);
        transportManagementSystem.addVehicle(vehicle3);
        transportManagementSystem.addVehicle(vehicle4);

        VehicleTracker vehicleTracker = new VehicleTracker(transportManagementSystem);
        vehicleTracker.startTracking(1);
        vehicleTracker.startTracking(3);
        vehicleTracker.startTracking(4);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        vehicleTracker.stopTracking();
    }
}
