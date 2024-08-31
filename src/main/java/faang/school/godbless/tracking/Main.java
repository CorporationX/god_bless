package faang.school.godbless.tracking;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Vehicle bus = new Vehicle(1);
        Vehicle anotherBus = new Vehicle(2);
        Vehicle car = new Vehicle(3);
        Vehicle anotherCar = new Vehicle(4);
        Vehicle cargo = new Vehicle(5);
        Vehicle anotherCargo = new Vehicle(6);

        VehicleTracker vehicleTracker = new VehicleTracker();
        vehicleTracker.addVehicle(bus);
        vehicleTracker.addVehicle(anotherBus);
        vehicleTracker.addVehicle(car);
        vehicleTracker.addVehicle(anotherCar);
        vehicleTracker.addVehicle(cargo);
        vehicleTracker.addVehicle(anotherCargo);

        vehicleTracker.initTrackingSystem();
        vehicleTracker.startTrackingSystem();
        vehicleTracker.stopTrackingSystem();

        vehicleTracker.getCurrentPositionVehicles();
    }
}
