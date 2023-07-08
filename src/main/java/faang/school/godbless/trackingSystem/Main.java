package faang.school.godbless.trackingSystem;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem tms = new TransportManagementSystem();

        Vehicle vehicle1 = new Vehicle(1, "Free", new Location(52.520008, 13.404954));
        Vehicle vehicle2 = new Vehicle(2, "Free", new Location(48.8566, 2.3522));

        tms.addVehicle(vehicle1);
        tms.addVehicle(vehicle2);

        VehicleTracker tracker = new VehicleTracker(tms);
        tracker.startTracking();

        tms.updateVehicleStatus(1, "Busy");
        tms.updateVehicleLocation(2, new Location(51.5074, 48.1278));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tracker.stopTracking();
    }

}
