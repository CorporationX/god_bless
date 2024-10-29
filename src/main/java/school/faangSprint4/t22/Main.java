package school.faangSprint4.t22;

import java.util.Map;

public class Main {
    private static final int SLEEP_TIME = 2000;

    public static void main(String[] args) {
        TransportManagementSystem tms = new TransportManagementSystem();

        tms.addVehicle(new Vehicle("V001", "FREE", new Location(55.7558, 37.6173)));
        tms.addVehicle(new Vehicle("V002", "BUSY", new Location(55.7517, 37.6178)));
        VehicleTracker tracker = new VehicleTracker(tms, 2);
        Map<String, Integer> trackingIntervals = Map.of(
                "V001", 5,
                "V002", 5
        );
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tracker.startTrackingMultiple(trackingIntervals);
    }
}