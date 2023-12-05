package faang.school.godbless.TrackingSystem;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(1, false, new Location(0, 0));
        Vehicle vehicle2 = new Vehicle(2, false, new Location(0, 0));
        Vehicle vehicle3 = new Vehicle(3, false, new Location(0, 0));
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        transportManagementSystem.addVehicle(vehicle1);
        transportManagementSystem.addVehicle(vehicle2);
        transportManagementSystem.addVehicle(vehicle3);

        VehicleTracker vehicleTracker = new VehicleTracker(transportManagementSystem);

        vehicleTracker.track();
    }
}
