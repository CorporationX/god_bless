package faang.school.godbless.BJS2_25405;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();
        Vehicle vehicle = new Vehicle(1, Status.BUSY, new Location(0, 0));
        system.putVehicle(1, vehicle);
        vehicle = new Vehicle(2, Status.BUSY, new Location(0, 0));
        system.putVehicle(2, vehicle);
        vehicle = new Vehicle(3, Status.BUSY, new Location(0, 0));
        system.putVehicle(3, vehicle);
        vehicle = new Vehicle(4, Status.BUSY, new Location(0, 0));
        system.putVehicle(4, vehicle);

        VehicleTracker vehicleTracker = new VehicleTracker(system);
        vehicleTracker.startTracking();
    }
}
