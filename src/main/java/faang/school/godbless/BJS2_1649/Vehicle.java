package faang.school.godbless.BJS2_1649;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Vehicle {
    private final int id;
    private final static AtomicInteger count = new AtomicInteger(1);
    private Location location;
    private boolean available;

    public Vehicle(Location location, boolean available) {
        this.available = available;
        this.location = location;
        this.id = count.getAndIncrement();
    }
}