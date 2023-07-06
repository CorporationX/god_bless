package faang.school.godbless.sprint4.tracking;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem tms = new TransportManagementSystem();

        Location location1 = new Location(52.521919, 13.413215);
        Vehicle vehicle1 = new Vehicle(1, true, location1);
        tms.addVehicle(vehicle1);

        Location location2 = new Location(52.523503, 13.426359);
        Vehicle vehicle2 = new Vehicle(2, true, location2);
        tms.addVehicle(vehicle2);

        VehicleTracker tracker = new VehicleTracker(tms);
        tracker.startTracking(1);
        tracker.startTracking(2);


        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Vehicle 1: location = (%f, %f), status = %s%n", vehicle1.getLocation().getLatitude(),
                    vehicle1.getLocation().getLongitude(), vehicle1.getStatus());
            System.out.printf("Vehicle 2: location = (%f, %f), status = %s%n", vehicle2.getLocation().getLatitude(),
                    vehicle2.getLocation().getLongitude(), vehicle2.getStatus());
        }
    }
}
