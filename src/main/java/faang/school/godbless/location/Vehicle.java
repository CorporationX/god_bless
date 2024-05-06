package faang.school.godbless.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Vehicle {
    private int id;
    @Setter
    private volatile StatusVehicle status;
    @Setter
    private volatile Location location;
}
