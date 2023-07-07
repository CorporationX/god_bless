package faang.school.godbless.sprint4.tracking;


import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {

    private TransportManagementSystem managementSystem;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private Random random = new Random();

    public VehicleTracker(TransportManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    public void startTracking(int id) {
        executorService.scheduleAtFixedRate(() -> {
            Location oldLocation = managementSystem.getVehicle(id).getLocation();
            double newLatitude = getRandomInRange(oldLocation.getLatitude() - 0.01, oldLocation.getLongitude() + 0.01);
            double newLongitude = getRandomInRange(oldLocation.getLongitude() - 0.01, oldLocation.getLatitude() + 0.01);
            managementSystem.updateLocation(id, newLatitude, newLongitude);

            boolean oldStatus = managementSystem.getVehicle(id).getStatus();
            boolean newStatus = !oldStatus;
            managementSystem.updateStatus(id, newStatus);
        }, 0, 1, TimeUnit.SECONDS);
    }

    private double getRandomInRange(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
}

