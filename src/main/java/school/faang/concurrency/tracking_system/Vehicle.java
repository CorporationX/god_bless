package school.faang.concurrency.tracking_system;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Vehicle {

    private final String id;
    private String status;
    private Location location;

    public void updateStatus(String newStatus) {
        status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        location = newLocation;
    }
}
