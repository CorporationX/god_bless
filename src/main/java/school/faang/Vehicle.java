package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {
    private final int id;
    private Status status;
    private Location location;

    public void updateStatus(Status newStatus) {
        status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        location = newLocation;
    }
}
