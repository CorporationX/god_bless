package derschrank.sprint04.task22.bjstwo_51227;

import derschrank.sprint04.task22.bjstwo_51227.units.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SPLITTER = "\n----------------------------\n";
    private static final int COUNT_OF_VEHICLES = 10;
    private static final int SHOWTIME_SEC = 20;

    public static void main(String[] args) {
        Management management = new TransportManagementSystem();
        VehicleTracker trackerEmulation = new VehicleTracker(management);

        List<Vehicle> vehicles = generateVehicles(COUNT_OF_VEHICLES);
        vehicles.forEach(vehicle -> {
            management.addVehicle(vehicle);
            trackerEmulation.startTrackEmulation(vehicle);
        });

        doSleep(SHOWTIME_SEC);
        trackerEmulation.stopTrackEmulation();

        System.out.println(SPLITTER + "INFO ON END:" + SPLITTER);
        vehicles.stream()
                .map(Vehicle::getId)
                .map(management::getVehicleInfo)
                .forEach(System.out::println);
    }


    private static List<Vehicle> generateVehicles(int count) {
        List<Vehicle> vehicles = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            vehicles.add(
                    new Vehicle("VEHICLE #" + i)
            );
        }
        return vehicles;
    }

    private static void doSleep(int delaySeconds) {
        try {
            Thread.sleep(delaySeconds * 1_000);
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted");
            ;
        }
    }
}


