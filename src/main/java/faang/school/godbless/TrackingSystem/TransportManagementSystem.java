package faang.school.godbless.TrackingSystem;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class TransportManagementSystem {
    private ConcurrentHashMap<Integer, Vehicle> vehicles;

    public TransportManagementSystem() {
        this.vehicles = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public synchronized void updateVehicleData(int i, Location location) {
        vehicles.computeIfPresent(i, (k, v) -> {
            if (ThreadLocalRandom.current().nextBoolean()) {
                v.updateStatus();
            }
            v.updateLocation(location);
            return v;
        });
    }

    public synchronized void printVehicleData(int i) {
        System.out.println(Thread.currentThread().getId() + " | " + vehicles.get(i));
    }
}
