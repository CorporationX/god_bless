package faang.school.godbless.transportTracking;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();

        transportManagementSystem.addVehicle(new Vehicle(1, "available", new Location(100, 100)));
        transportManagementSystem.addVehicle(new Vehicle(2, "available", new Location(50, 50)));
        transportManagementSystem.addVehicle(new Vehicle(3, "available", new Location(120, 120)));
        transportManagementSystem.addVehicle(new Vehicle(4, "available", new Location(200, 100)));
        transportManagementSystem.addVehicle(new Vehicle(5, "available", new Location(80, 120)));

        VehicleTracker vehicleTracker = new VehicleTracker(transportManagementSystem);
        vehicleTracker.track();
        Thread.sleep(20000);
        vehicleTracker.stop();
    }
}
