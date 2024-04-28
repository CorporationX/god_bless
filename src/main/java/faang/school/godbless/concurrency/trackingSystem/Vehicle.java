package faang.school.godbless.concurrency.trackingSystem;

import lombok.Data;

@Data
public class Vehicle {
    private final int id;
    private volatile boolean status; //isTaken
    private Location currentLocation;

    public Vehicle(int id, Location currentLocation) {
        this.id = id;
        this.currentLocation = currentLocation;
        status = false;
    }
}
