package school.faang.trackingsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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


