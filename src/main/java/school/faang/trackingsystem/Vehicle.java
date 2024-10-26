package school.faang.trackingsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Vehicle {
    private final String id;
    private volatile String status;
    private volatile Location location;

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }
}

