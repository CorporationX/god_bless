package school.faang.gps_tracker;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Vehicle {
    private final String id;
    private volatile VehicleStatus status;
    private volatile Location location;

    public void updateStatus(VehicleStatus newStatus) {
        this.status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }
}
