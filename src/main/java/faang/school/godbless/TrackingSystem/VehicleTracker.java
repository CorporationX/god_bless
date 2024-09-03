package faang.school.godbless.TrackingSystem;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private ScheduledExecutorService executor;
    @Getter
    private TransportManagementSystem transportManagementSystem;

    public VehicleTracker() {
        executor = Executors.newScheduledThreadPool(5);
        transportManagementSystem = new TransportManagementSystem();
    }

    public void startTracking() {
        executor.scheduleAtFixedRate(() -> {
            for (int i = 1; i <= transportManagementSystem.getTransportsById().size(); i++) {
                Vehicle tempVehicle = getTransport(i);
                if (!tempVehicle.isAvailable()) {
                    transportManagementSystem.updateTransportLocation(i,tempVehicle.getLocation().getLatitude() + 10,
                            tempVehicle.getLocation().getLongitude() + 20);
                    transportManagementSystem.printTransports();
                } else {
                    System.out.println(tempVehicle.getId() + " сейчас свободен");
                }

            }
        }, 0,5, TimeUnit.SECONDS);
    }

    public void addTransport(Vehicle vehicle) {
        transportManagementSystem.addTransport(vehicle);
    }

    public Vehicle getTransport(int id) {
        return transportManagementSystem.getTransportById(id);
    }

}
