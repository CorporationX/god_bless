package faang.school.godbless.tracking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Vehicle {
    private final int id;
    private boolean isFree;
    private Location location;

    public Vehicle(int id, boolean isFree, Location location) {
        this.id = id;
        this.isFree = isFree;
        this.location = location;
    }
}
