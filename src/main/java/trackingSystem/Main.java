package trackingSystem;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();
        for (int i = 0; i < 3; i++) {
            system.addVehicle(new Vehicle(false, "AB" + i, new Location(0, 0)));
        }

        System.out.println("=====AFTER ADDED=====");
        printInfo(system);

        VehicleTracker tracker = new VehicleTracker();
        tracker.update(system.getVehicles());

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("=====UPDATING INFO=====");
            printInfo(system);
        }
    }

    static void printInfo(TransportManagementSystem system) {
        system.getVehicles().entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().isStatus());
            System.out.println("x: " + entry.getValue().getLocation().getLatitude());
            System.out.println("y: " + entry.getValue().getLocation().getLongitude());
            System.out.println("================================");
        });
    }
}
