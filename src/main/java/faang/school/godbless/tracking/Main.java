package faang.school.godbless.tracking;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TransportManagementSystem system = new TransportManagementSystem(
                List.of(
                        new Vehicle(1, true, new Location(100, 200)),
                        new Vehicle(2, true, new Location(10, 220)),
                        new Vehicle(3, true, new Location(31, 24)),
                        new Vehicle(4, true, new Location(130, 250)),
                        new Vehicle(5, true, new Location(201, 120)),
                        new Vehicle(6, true, new Location(4, 3))
                )
        );

        VehicleTracker tracker = new VehicleTracker(system);
        tracker.startUpdating();

        Thread.sleep(5_000);

        tracker.stopUpdating();
        System.out.println(Arrays.toString(system.getInfo().entrySet().toArray()));
    }
}
