package school.faang.trackingsystem;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem tms = new TransportManagementSystem();

        Vehicle vehicle1 = new Vehicle("vehicle1", "free", new Location(40.7128, -74.0060));
        Vehicle vehicle2 = new Vehicle("vehicle2", "busy", new Location(34.0522, -118.2437));

        tms.addVehicle(vehicle1);
        tms.addVehicle(vehicle2);

        VehicleTracker tracker = new VehicleTracker(tms);
        tracker.startTracking();

        try {
            Thread.sleep(20000); // Simulate some time for tracking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tracker.stopTracking();
    }
}
