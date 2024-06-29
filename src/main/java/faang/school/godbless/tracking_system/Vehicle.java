package faang.school.godbless.tracking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Vehicle {
    private final int id;
    private VehicleStatus vehicleStatus;
    private Location location;
}
