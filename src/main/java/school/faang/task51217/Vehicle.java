package school.faang.task51217;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
public class Vehicle {
    private final int id;
    private Status status;
    private Location location;

    public void updateStatus(Status newStatus) {
        Objects.requireNonNull(newStatus);

        if (newStatus == status) {
            throw new IllegalArgumentException("Транспортное средство уже имеет этот статус");
        }

        status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        Objects.requireNonNull(newLocation);

        location = newLocation;
    }
}
