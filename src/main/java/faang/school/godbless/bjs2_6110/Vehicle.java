package faang.school.godbless.bjs2_6110;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Vehicle {

    private final int id;
    @Setter
    private volatile StatusVehicle status = StatusVehicle.FREE;
    @Setter
    private volatile Location location;

    public Vehicle(int id, Location location) {
        this.id = id;
        this.location = location;
    }
}
