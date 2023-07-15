package faang.school.godbless.trackingSystem;

import lombok.Getter;

@Getter
public class Vehicle {
    private final int id;
    private volatile String status;
    private volatile Location location;

    public Vehicle(int id, String status, Location location) {
        this.id = id;
        this.status = status;
        this.location = location;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }
}
