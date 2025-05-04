package school.faang.gps_tracker;

import lombok.Data;

@Data
public class Vehicle {
    private final String id;
    private volatile VehicleStatus status;
    private volatile Location location;

    public Vehicle(String id, VehicleStatus status, Location location) {
        this.id = id;
        this.status = status;
        this.location = location;
    }

    public void updateStatus(VehicleStatus newStatus) {
        this.status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }
}
