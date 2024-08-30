package faang.school.godbless.trackingsystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Vehicle {
    private final long id;
    @Setter
    private volatile Status status;
    @Setter
    private volatile Location location;

    public Vehicle(long id, Location location) {
        this.id = id;
        this.status = Status.FREE;
        this.location = location;
    }
}