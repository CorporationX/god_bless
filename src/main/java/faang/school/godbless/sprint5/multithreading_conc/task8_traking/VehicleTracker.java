package faang.school.godbless.sprint5.multithreading_conc.task8_traking;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class VehicleTracker {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle(1, Status.FREE, new Location());
        Vehicle vehicle2 = new Vehicle(2, Status.BUSY, new Location());
        Vehicle vehicle3 = new Vehicle(3, Status.FREE, new Location());
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);

    }
}
