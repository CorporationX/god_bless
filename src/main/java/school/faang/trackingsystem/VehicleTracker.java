package school.faang.trackingsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VehicleTracker {
    private static final TransportManagementSystem TRANSPORT_MANAGEMENT_SYSTEM = new TransportManagementSystem();
    private static final ScheduledExecutorService SCHEDULER =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    private static final List<Vehicle> VEHICLES = List.of(
            new Vehicle("Haval"), new Vehicle("Lada"), new Vehicle("UAZ"),
            new Vehicle("Honda"), new Vehicle("Mitsubishi"), new Vehicle("Nissan"),
            new Vehicle("Audi"), new Vehicle("Cadillac"), new Vehicle("Ford"),
            new Vehicle("BMW"), new Vehicle("Hyundai"), new Vehicle("Ferrari")
    );
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final double MAX_SPEED_VEHICLES = 50;
    private static final int DELAY_BETWEEN_TRACKING = 3;
    private static final int DELAY_BEFORE_START_TRACKING = 3;
    private static final TimeUnit TIME_UNIT_DELAY_TRACKING = TimeUnit.SECONDS;
    private static final int TIME_EXECUTION_TRACKING = 1;
    private static final TimeUnit TIME_UNIT_EXECUTION_TRACKING = TimeUnit.MINUTES;

    public static void startTracking(Vehicle vehicle) {
        Runnable task = () -> {
            UUID id = vehicle.getId();
            Location newLocation;
            if (ThreadLocalRandom.current().nextBoolean()) {
                newLocation = new Location(
                        vehicle.getLocation().latitude() - RANDOM.nextDouble(MAX_SPEED_VEHICLES),
                        vehicle.getLocation().longitude());
            } else {
                newLocation = new Location(
                        vehicle.getLocation().latitude(),
                        vehicle.getLocation().longitude() - RANDOM.nextDouble(MAX_SPEED_VEHICLES));
            }
            TRANSPORT_MANAGEMENT_SYSTEM.updateVehicleLocation(id, newLocation);
            TRANSPORT_MANAGEMENT_SYSTEM.getVehicleInfo(id);
        };

        SCHEDULER.scheduleAtFixedRate(
                task, DELAY_BEFORE_START_TRACKING, DELAY_BETWEEN_TRACKING, TIME_UNIT_DELAY_TRACKING);
        SCHEDULER.schedule(SCHEDULER::shutdown, TIME_EXECUTION_TRACKING, TIME_UNIT_EXECUTION_TRACKING);
    }

    public static void main(String[] args) {
        VEHICLES.forEach(TRANSPORT_MANAGEMENT_SYSTEM::addVehicle);

        VEHICLES.forEach(VehicleTracker::startTracking);
    }
}
