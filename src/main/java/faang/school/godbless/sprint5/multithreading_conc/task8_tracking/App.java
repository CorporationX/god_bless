package faang.school.godbless.sprint5.multithreading_conc.task8_tracking;

public class App {

    public static void main(String[] args) throws InterruptedException {

        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker(transportManagementSystem);
        for (int i = 0; i < 5; i++) {
            Vehicle vehicle1 = new Vehicle(i, Status.FREE, new Location());
            transportManagementSystem.addVehicle(vehicle1);
        }

        vehicleTracker.trackingVehicle();
    }
}
