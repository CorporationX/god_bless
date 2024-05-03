package faang.school.godbless.tracking_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private Map<Integer, Vehicle> transports;

    public TransportManagementSystem() {
        this.transports = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        transports.put(vehicle.getId(), vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        transports.computeIfPresent(vehicle.getId(), (id, oldVehicle) -> vehicle);
    }

    public void removeVehicleById(int id) {
        transports.remove(id);
    }

    public List<Vehicle> getAllTransports() {
        return new ArrayList<>(transports.values());
    }
}
