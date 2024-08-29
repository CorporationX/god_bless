package faang.school.godbless.BJS2_25365;

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem transportManagement = new TransportManagementSystem();
        VehicleTracker vehicleTracker = new VehicleTracker();

        for (int i = 0; i < 5; i++) {
            transportManagement.addVehicle(new Vehicle(i, STATUS.FREE, new Location()));
        }

        System.out.println(transportManagement.getVehicles());

        vehicleTracker.changeLocation(transportManagement);
        vehicleTracker.shutdown();
        System.out.println(transportManagement.getVehicles());
    }
}
