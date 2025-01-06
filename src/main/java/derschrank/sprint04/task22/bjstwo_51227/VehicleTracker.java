package derschrank.sprint04.task22.bjstwo_51227;

import derschrank.sprint04.task22.bjstwo_51227.units.Location;
import derschrank.sprint04.task22.bjstwo_51227.units.Status;
import derschrank.sprint04.task22.bjstwo_51227.units.Vehicle;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private static final int SIZE_OF_THREAD_POOL = 50;
    private static final int LOCATION_FREQUENCY_UPDATE_SEC = 5;
    private static final int LOCATION_DELAY_UPDATE_SEC = 7;
    private static final int STATUS_FREQUENCY_UPDATE_SEC = 10;
    private static final int STATUS_DELAY_UPDATE_SEC = 1;
    private static final double DELTA_FOR_LOCATION_GENERATION = 0.1;

    private final ScheduledExecutorService executor;
    private final List<ScheduledFuture<?>> futures;
    private final Management management;

    public VehicleTracker(Management management) {
        executor = Executors.newScheduledThreadPool(SIZE_OF_THREAD_POOL);
        futures = new LinkedList<>();
        this.management = management;
    }

    public void startTrackEmulation(Vehicle vehicle) {
        String vehicleId = vehicle.getId();
        trackVehicleEmulation(vehicleId);
        statusVehicleEmulation(vehicleId);
    }

    public synchronized void stopTrackEmulation() {
        futures.forEach(f -> f.cancel(true));
        executor.shutdownNow();
    }

    private synchronized void trackVehicleEmulation(String vehicleId) {
        if (management.isThereVehicle(vehicleId)) {
            futures.add(
                    executor.scheduleAtFixedRate(() -> {
                                Location oldLocation = management.getVehicleLocation(vehicleId);
                                Location newLocation = generateRandomLocation(oldLocation);
                                management.updateVehicleLocation(vehicleId, newLocation);
                            },
                            LOCATION_DELAY_UPDATE_SEC,
                            LOCATION_FREQUENCY_UPDATE_SEC,
                            TimeUnit.SECONDS
                    )
            );
        }
    }

    private synchronized void statusVehicleEmulation(String vehicleId) {
        if (management.isThereVehicle(vehicleId)) {
            futures.add(
                    executor.scheduleAtFixedRate(() -> {
                                Status oldStatus = management.getVehicleStatus(vehicleId);
                                Status newStatus = generateStatus(oldStatus);
                                management.updateVehicleStatus(vehicleId, newStatus);
                            },
                            STATUS_DELAY_UPDATE_SEC,
                            STATUS_FREQUENCY_UPDATE_SEC,
                            TimeUnit.SECONDS
                    )
            );
        }
    }


    private Location generateRandomLocation(Location oldLocation) {
        Random rnd = ThreadLocalRandom.current();
        return new Location(
                oldLocation.latitude() + rnd.nextDouble(DELTA_FOR_LOCATION_GENERATION),
                oldLocation.longitude() + rnd.nextDouble(DELTA_FOR_LOCATION_GENERATION)
        );
    }

    private Status generateStatus(Status oldStatus) {
        if (oldStatus == Status.FREE) {
            return Status.BUSY;
        } else {
            return Status.FREE;
        }
    }
}
