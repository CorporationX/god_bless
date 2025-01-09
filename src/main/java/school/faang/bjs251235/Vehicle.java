package school.faang.bjs251235;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Vehicle {

    private final String vehicleId;
    private volatile Status status;
    private volatile Location location;

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }
}