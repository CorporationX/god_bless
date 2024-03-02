package faang.school.godbless.trackingsys;

public class Main {

    public static void main(String[] args) {
        TransportManagementSystem managementSystem = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker(managementSystem);
        addVehicles(managementSystem);

        vehicleTracker.startTracking();
    }

    private static void addVehicles(TransportManagementSystem system) {
        for (int i = 1; i <= 30; i++) {
            system.addVehicle(new Vehicle(i, Status.getRandomStatus(), Location.getRandomLocation()));
        }
    }
}
