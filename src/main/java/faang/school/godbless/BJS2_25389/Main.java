package faang.school.godbless.BJS2_25389;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    private static final int CORE_POOL_SIZE = 5;
    private static final long SHOW_INFO_PERIOD = 4;
    private static final long TRANSPORT_SYSTEM_WORK_DURATION = 32;

    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();

        Vehicle carOne = new Vehicle(1, "WITH_PASSENGER", new Location(59.908923, 30.275098));
        Vehicle carTwo = new Vehicle(2, "WITHOUT_PASSENGER", new Location(59.853019, 30.103965));
        Vehicle carThree = new Vehicle(3, "WITH_PASSENGER", new Location(60.097876, 30.299844));

        system.addVehicle(carOne);
        system.addVehicle(carTwo);
        system.addVehicle(carThree);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        VehicleTracker trackerOne = new VehicleTracker(carOne, executor);
        VehicleTracker trackerTwo = new VehicleTracker(carTwo, executor);
        VehicleTracker trackerThree = new VehicleTracker(carThree, executor);

        trackerOne.startTracking();
        trackerTwo.startTracking();
        trackerThree.startTracking();

        executor.scheduleAtFixedRate(system::showAllTransport, 0, SHOW_INFO_PERIOD, TimeUnit.SECONDS);
        executor.schedule(executor::shutdownNow, TRANSPORT_SYSTEM_WORK_DURATION, TimeUnit.SECONDS);
    }
}
